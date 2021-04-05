package tests;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.io.IOException;

public class HomePageTest extends Base {
    public WebDriver driver;

    @BeforeTest
    public void setup() throws IOException {
        driver = initialize();
    }


    @Test
    public void ClickSearchButtonTest() {
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        homePage.getSearchBtn().click();

    }

    @Test
    public void homePageTest1() {
        System.out.println("Home Page test1 success");

    }

    @Test
    public void homePageTest2() {
        System.out.println("Home Page test2 success");

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
