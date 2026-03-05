package Utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class JsonDataReader {

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
