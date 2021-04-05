package utilities;

import base.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


public class Listener extends Base implements ITestListener {
    ExtentTest test;
    ExtentReports extentReports = ExtentReportNG.getReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    public void onTestStart(ITestResult result) {
        test = extentReports.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed");
    }

    public void onTestFailure(ITestResult result) {
//To print logs when test fails
        extentTest.get().fail(result.getThrowable());
        System.out.println("Test Failed");
        //To Take screenshot on failure

        WebDriver driver =null;

        try{

            driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        String methodName = result.getMethod().getMethodName();

        try{
            extentTest.get().addScreenCaptureFromPath(getScreenShotPath(methodName,driver), result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

        extentReports.flush();

    }
}
