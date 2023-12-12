package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class finalPage {
    private WebDriver driver;
    private final By accountPageTitle= By.xpath("//b[contains(text(),\"Account Created\")]");
    public finalPage(WebDriver driver) {
        this.driver = driver;
    }
    public void assertAccountCreated(String expectedResult){
        String actualAccountCreated = driver.findElement(accountPageTitle).getText();
        Assert.assertEquals(actualAccountCreated, expectedResult);
    }
}
