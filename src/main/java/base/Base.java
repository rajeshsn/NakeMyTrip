package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;

    public Properties prop;

    public WebDriver initialize() throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\Rajesh\\Documents\\NakeMyTrpAutomationFramework\\src\\main\\resources\\config.properties");

        prop = new Properties();
        prop.load(fis);

        String browserName = prop.getProperty("browser");


        if (browserName.equals("chrome")) {

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rajesh\\Documents\\NakeMyTrpAutomationFramework\\src\\main\\resources\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("disable-popup-blocking");
            driver = new ChromeDriver(options);

        } else if (browserName.equals("firefox")) {

            System.setProperty("webdriver.gecko.driver", "C://Users//Rajesh//Documents//NakeMyTrpAutomationFramework//src//main//resources//geckodriver.exe");

            driver = new FirefoxDriver();

        }

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        return driver;
    }

    public String getScreenShotPath(String testCaseName , WebDriver driver) throws IOException {

       TakesScreenshot screenShot= (TakesScreenshot) driver;
       File srcFile= screenShot.getScreenshotAs(OutputType.FILE);
       String destinationPath=System.getProperty("usr.dir")+"\\screenShot\\"+testCaseName+".png";
        FileUtils.copyFile(srcFile,new File(destinationPath));
        return destinationPath;

    }
}
