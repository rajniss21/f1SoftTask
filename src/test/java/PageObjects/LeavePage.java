package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeavePage {

    public WebDriver driver;

    public LeavePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(text(),'Assign Leave')]")
    WebElement AssignLeave;

    @FindBy(xpath = "(//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"])[1]")
    WebElement ValidationMessage;

    @FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]")
    WebElement AssignBtn;

    public WebElement clickAssignLeaveTab(){
        return AssignLeave;
    }
    public WebElement clickAssignBtn(){
        return AssignBtn;
    }
    public String getValidationText(){
        String heading1 = ValidationMessage.getText();
        return heading1;
    }
}
