package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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

    public void clickAssignLeaveTab(){
        AssignLeave.click();
    }
    public void clickAssignBtn(){
        AssignBtn.click();
    }
    public void getValidationText(){
        String actualMessage =  ValidationMessage.getText();
        String expectedMessage = "Required";
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
