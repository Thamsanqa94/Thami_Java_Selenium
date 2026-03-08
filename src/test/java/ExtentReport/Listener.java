package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    private static final ExtentReports extentReport = ExtentReportManager.getExtentReport();
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReport.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = extentTest.get();
        if (test != null) {
            test.fail("Test failed: " + result.getThrowable());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test = extentTest.get();
        if (test != null) {
            test.skip("Test skipped: " + result.getThrowable());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReport.flush();
        extentTest.remove();
    }
}
