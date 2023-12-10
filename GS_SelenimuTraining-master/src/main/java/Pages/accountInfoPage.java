package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class accountInfoPage {
    private WebDriver driver;
    private final By accountInfopageTitle = By.xpath("//b[contains(text(),\"Enter Account\")]");
    private final By accountGender = By.id("id_gender1");
    private final By accountPassword= By.id("password");
    private final By daysDate=By.id("days");
    private final By monthsDate=By.id("months");
    private final By yearsDate= By.id("years");
    private final By newsLetter=By.id("newsletter");
    private final By option=By.id("optin");
    private final By firstName=By.id("first_name");
    private final By lastName=By.id("last_name");
    private final By companyName=By.id("company");
    private final By address1Name=By.id("address1");
    private final By address2Name=By.id("address2");
    private final By countryList=By.id("country");
    private final By stateName=By.id("state");
    private final By cityName=By.id("city");
    private final By zipcodeName=By.id("zipcode");
    private final By mobileNumber=By.id("mobile_number");
    private final By submitButton= By.xpath("//button[contains(text(),\"Create Account\")]");
    public accountInfoPage(WebDriver driver) {
        this.driver = driver;
    }
    public void fillAccountInfoForm(String password, String Day, String month, String year, String firstname,
                                    String lastname, String company, String address1, String address2,
                                    String country, String state, String city, String zipcode, String mobilenumber){
        driver.findElement(accountGender).click();
        driver.findElement(accountPassword).sendKeys(password);
        Select daysList =new Select(driver.findElement(daysDate));
        daysList.selectByVisibleText(Day);
        Select monthList =new Select(driver.findElement(monthsDate));
        monthList.selectByVisibleText(month);
        Select yearList =new Select(driver.findElement(yearsDate));
        yearList.selectByVisibleText(year);
        driver.findElement(newsLetter).click();
        driver.findElement(option).click();
        driver.findElement(firstName).sendKeys(firstname);
        driver.findElement(lastName).sendKeys(lastname);
        driver.findElement(companyName).sendKeys(company);
        driver.findElement(address1Name).sendKeys(address1);
        driver.findElement(address2Name).sendKeys(address2);
        Select countrylist= new Select(driver.findElement(countryList));
        countrylist.selectByVisibleText(country);
        driver.findElement(stateName).sendKeys(state);
        driver.findElement(cityName).sendKeys(city);
        driver.findElement(zipcodeName).sendKeys(zipcode);
        driver.findElement(mobileNumber).sendKeys(mobilenumber);
        driver.findElement(submitButton).click();
    }
    public void assertEnterAccountInfoPage(String expectedResult){
        String actualAccountInfoTitle = driver.findElement(accountInfopageTitle).getText();
        Assert.assertEquals(actualAccountInfoTitle, expectedResult);
    }
}
