package Helpers;

import PageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNGException;
import org.testng.annotations.*;

import java.time.Duration;

import static Helpers.Helper.*;

public class Hooks {

   public WebDriver driver = null ;

    @Parameters("browserName")
    @BeforeMethod
    public void loadData(String browserName){
        readConfig();
       driver =  createInstance(browserName);
    }

    @AfterMethod
    public void tearDown(){
        try {
            WebDriver driver = this.driver;
            if (driver != null) {
                driver.quit();
            }
        } catch (TestNGException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver createInstance(String browserName) {
        WebDriver driver = null;
        try {
            if(browserName.equalsIgnoreCase("chrome")){
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver(options);
            } else if (browserName.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("safari")) {
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
            }
            driver.get(prop.getProperty("BaseUrl"));
            Thread.sleep(5000);
            return driver;
        } catch (Exception errorCreateInstance) {
            System.out.println("Cannot create Instance due to :" + errorCreateInstance);
        }
        return driver;
    }
    public void waitForThisTobeClickable(WebElement elementToWait) {
        WebDriverWait waitForOption = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForOption.until(ExpectedConditions.elementToBeClickable(elementToWait));
    }

    public void jsClickExecutor(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }
    public void waitForElementToBeVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void loginToTheModule() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("password"));
        loginPage.clickLoginButton();
        loginPage.validateLogin();
    }
}
