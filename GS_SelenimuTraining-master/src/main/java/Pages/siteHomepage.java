package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class siteHomepage {
    private WebDriver driver;

    String sitehomePageURL= "https://automationexercise.com/";

    // Locators
    private final By signupButton = By.xpath("//i[@class=\"fa fa-lock\"]");

    public siteHomepage(WebDriver driver) {
        this.driver = driver;
    }


    // Actions
    public void navigateToHomePage() {
        driver.navigate().to(sitehomePageURL);
    }
    public void pressonSignup() {
        driver.findElement(signupButton).click();
    }
    public void asserthomepage(String expecteResult){
        String actualHomePageTitle = driver.getCurrentUrl();
        Assert.assertEquals(actualHomePageTitle,expecteResult);
    }

}
