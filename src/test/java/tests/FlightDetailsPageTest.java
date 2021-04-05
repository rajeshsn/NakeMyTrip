package tests;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class FlightDetailsPageTest extends Base {


    public WebDriver driver;

    @BeforeTest

    public void invokeDriver() throws IOException {

        driver = initialize();
    }

    @Test
    public void flightDetailsTest1() {
        System.out.println("FlightPage Test1 success");
    }

    public void flightDetailsTest2() {
        System.out.println("FlightPage Test2 success");
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
