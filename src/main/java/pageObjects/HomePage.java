package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    public WebDriver driver;

    By searchBtn = By.xpath("//a[contains(text(),'Search')]");

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }


    public WebElement getSearchBtn() {

        return driver.findElement(searchBtn);

    }
}

