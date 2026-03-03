package Utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class JsonDataReader {

    /**
     * Reads a JSON array file from the test resources and returns its entries
     * as a two-dimensional Object array suitable for a TestNG @DataProvider.
     *
     * Each element of the outer array corresponds to one JSON object in the file.
     * The inner array contains the JsonNode for that object so individual fields
     * can be read with {@code node.get("fieldName").asText()}.
     *
     * @param resourcePath path relative to the test classpath root,
     *                     e.g. {@code "testdata/login_data.json"}
     * @return Object[][] where each row is {@code { JsonNode }}
     */
    public static Object[][] getJsonData(String resourcePath) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            try (InputStream stream = JsonDataReader.class
                    .getClassLoader()
                    .getResourceAsStream(resourcePath)) {
                if (stream == null) {
                    throw new RuntimeException("Test data file not found on classpath: " + resourcePath);
                }
                JsonNode root = mapper.readTree(stream);
                Object[][] data = new Object[root.size()][1];
                for (int i = 0; i < root.size(); i++) {
                    data[i][0] = root.get(i);
                }
                return data;
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON test data from: " + resourcePath, e);
        }
    }
}
