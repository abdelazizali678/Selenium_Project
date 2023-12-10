import framework.engine.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.accountInfoPage;
import Pages.finalPage;
import Pages.signupPage;
import Pages.siteHomepage;


public class  ActualPOMExercise {
        private WebDriver driver;
        private siteHomepage siteHomepage;
        private signupPage signupPage;
        private  finalPage finalPage;
        private  accountInfoPage accountInfoPage;

        ///Tests
        @Test
        public void test1() {
            siteHomepage.asserthomepage("https://automationexercise.com/");
        }

        @Test
        public void test2() {
            siteHomepage.pressonSignup();
            signupPage.assertSignUppage("New User Signup!");
            //
            signupPage.fillSignupFormandSubmit("Ahmed", "ahmed5050201@gmail.com");
            //
            accountInfoPage.assertEnterAccountInfoPage("ENTER ACCOUNT INFORMATION");

        }
        @Test
        public void test3(){
            accountInfoPage.fillAccountInfoForm("ahmed505051@gmail.com", "2", "January", "2020", "Ahmed",
                    "Mohamed", "Giza", "address1", "address2", "Canada", "state",
                    "city", "012345", "0123455555");
            finalPage.assertAccountCreated("ACCOUNT CREATED!");
        }

        @BeforeClass
        public void openbrowserNavigateToHomePage() {
            //driver = new FirefoxDriver();
            //driver.manage().window().maximize();
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver = DriverFactory.initDriver("firefox", 20,true, true);
            siteHomepage = new siteHomepage(driver);
            signupPage = new signupPage(driver);
            accountInfoPage= new accountInfoPage(driver);
            finalPage= new finalPage(driver);
            siteHomepage.navigateToHomePage();
        }

        @AfterClass
        public void closeBrowser() {
            driver.quit();
        }

    }