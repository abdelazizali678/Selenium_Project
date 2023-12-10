import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.annotations.IBeforeMethod;

public class AutomationExercise {
    WebDriver driver = null;
    @BeforeClass
    public void openbrowser(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");
    }
    @Test(priority = 0)
    public void homePageloaded(){
        String homelink = driver.getCurrentUrl();
        Assert.assertEquals(homelink,"https://automationexercise.com/", "Verify that home page loaded successfully");
    }

    @Test(priority = 1)
    public void clickonSignup(){
        WebElement signup = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        signup.click();
        WebElement text = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2"));
        String textt = text.getText(); ;
        Assert.assertEquals("New User Signup!",textt);
    }

    @Test(priority = 2)
    public void inputData(){
        driver.findElement(By.name("name")).sendKeys("Ahmed");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("ahmed505051@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
        WebElement text2= driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/h2"));
        String text2t = text2.getText();
        Assert.assertEquals(text2t, "ENTER ACCOUNT INFORMATION");
    }

    @Test(priority = 3)
    public void fillForm(){
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys("ahmed505051@gmail.com");
        Select dayslist = new Select(driver.findElement(By.id("days")));
        dayslist.selectByVisibleText("2");
        Select monthlist = new Select(driver.findElement(By.id("months")));
        monthlist.selectByVisibleText("January");
        Select yearlist = new Select(driver.findElement(By.id("years")));
        yearlist.selectByVisibleText("2020");
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.id("first_name")).sendKeys("Ahmed");
        driver.findElement(By.id("last_name")).sendKeys("Mohamed");
        driver.findElement(By.id("company")).sendKeys("Giza");
        driver.findElement(By.id("address1")).sendKeys("address1");
        driver.findElement(By.id("address2")).sendKeys("address2");
        Select countrylist = new Select(driver.findElement(By.id("country")));
        countrylist.selectByVisibleText("Canada");
        driver.findElement(By.id("state")).sendKeys("state");
        driver.findElement(By.id("city")).sendKeys("city");
        driver.findElement(By.id("zipcode")).sendKeys("012345");
        driver.findElement(By.id("mobile_number")).sendKeys("0123455555");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button")).click();
        WebElement finaltext= driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        String finaltextt= finaltext.getText();
        Assert.assertEquals(finaltextt,"ACCOUNT CREATED!");

    }
    @AfterClass
    public void cloaseBrowser(){
        driver.quit();
    }

}
