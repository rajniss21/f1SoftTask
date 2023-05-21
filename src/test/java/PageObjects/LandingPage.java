package PageObjects;

import Helpers.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends Hooks {
    public WebDriver driver;


    public LandingPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath ="//li[@class='oxd-main-menu-item-wrapper'][1]")
    WebElement adminModule;
    @FindBy(xpath ="//li[@class='oxd-main-menu-item-wrapper'][2]")
    WebElement pimModule;
    @FindBy(xpath = "//li[@class='oxd-main-menu-item-wrapper'][3]")
    WebElement leave;

    @FindBy(xpath = "//li[@class='oxd-main-menu-item-wrapper'][8]")
    WebElement dashboard;

    public void clickAdminModule() {
        adminModule.click();
    }

    public void clickOnPIMModule(){
        pimModule.click();
    }
    public void clickOnLeaveModule(){leave.click();}

    public void clickOnDashboardModule(){
        dashboard.click();
    }

}
