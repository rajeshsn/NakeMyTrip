package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG {

    static  ExtentReports extentReports;

    public  static ExtentReports  getReportObject() {
        String path = System.getProperty("user.dir") +"//test-output//testReport.html";
        ExtentSparkReporter  reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Test Result");
        reporter.config().setDocumentTitle("Test Result");
        reporter.config().setTheme(Theme.STANDARD);
        reporter.config().setEncoding("utf-8");
        reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Tester", "Rajesh");
        extentReports.setSystemInfo("OS", "Windows");
        return extentReports;
    }
}
