package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static final String REPORT_FILE_PATH = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
    private static final ExtentReports extentReport;

    static {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORT_FILE_PATH);
        sparkReporter.config().setDocumentTitle("Ndosi Automation Test Report");
        sparkReporter.config().setReportName("Ndosi Automation Test Results");

        extentReport = new ExtentReports();
        extentReport.attachReporter(sparkReporter);
        extentReport.setSystemInfo("Tester", "Xoxoshololo");
        extentReport.setSystemInfo("Environment", "QA");
    }

    private ExtentReportManager() {
    }

    public static ExtentReports getExtentReport() {
        return extentReport;
    }
}
