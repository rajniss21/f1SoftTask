package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    public WebDriver driver;

    public LandingPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath ="//li[@class='oxd-main-menu-item-wrapper'][1]")
    WebElement AdminModule;
    @FindBy(xpath ="//li[@class='oxd-main-menu-item-wrapper'][2]")
    WebElement PIMModule;
    @FindBy(xpath = "//li[@class='oxd-main-menu-item-wrapper'][3]")
    WebElement Leave;

    public WebElement clickAdminModule(){
        return AdminModule;
    }
    public WebElement clickOnPIMModule(){
        return PIMModule;
    }
    public WebElement clickOnLeaveModule(){return Leave;}

}
