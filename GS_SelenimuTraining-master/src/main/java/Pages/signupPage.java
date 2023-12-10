package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class signupPage {
    private WebDriver driver;
    private final By signupPageTitle = By.xpath("//h2[contains(text(),\"New User\")]");
    private final By nameField = By.xpath("//input[@name=\"name\"]");
    private final By emailField = By.xpath("//input[@data-qa= \"signup-email\"]");
    private final By submitSignUpButton = By.xpath("//button[@data-qa= \"signup-button\"]");
    public signupPage(WebDriver driver) {
        this.driver = driver;
    }
    public void fillSignupFormandSubmit(String Name, String Email){
        driver.findElement(nameField).sendKeys(Name);
        driver.findElement(emailField).sendKeys(Email);
        driver.findElement(submitSignUpButton).click();
    }
    public void assertSignUppage(String expecteResult){
        String actualSignUpPageTitle = driver.findElement(signupPageTitle).getText();
        Assert.assertEquals(actualSignUpPageTitle,expecteResult);
    }

}
