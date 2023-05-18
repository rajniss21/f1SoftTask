package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MM_AdminPage {
    public WebDriver driver;
    public MM_AdminPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement userAddBtn;
    @FindBy(xpath = "(//div[contains(text(),'-- Select --')])[1]")
    WebElement userRole;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeNameTextBox;
    @FindBy(xpath = "(//div[@class='oxd-select-wrapper'])[2]/div/div[1]")
    WebElement status;
    @FindBy(xpath = "//div[@class='oxd-form-row']/div/div[4]/div/div[2]/input")
    WebElement username;
    @FindBy(xpath = "(//input[@type='password'])[1]")
    WebElement password;
    @FindBy(xpath = "(//input[@type='password'])[2]")
    WebElement confirmPassword;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveBtn;
    @FindBy(xpath = "//div[@role='option'][2]")
    WebElement adminRole_Status;
    @FindBy(xpath ="//div[@role='option']")
    WebElement selectEmployee;

    public WebElement selectEmployee(){
        return selectEmployee;
    }
    public WebElement clickAdminRole(){return adminRole_Status;}
    public WebElement clickUserAddBtn(){
        return userAddBtn;
    }
    public WebElement selectUserRole(){
        return userRole;
    }
    public WebElement selectEmployeeTextBox(){
        return employeeNameTextBox;
    }
    public WebElement clickStatusDropdown(){return status;}
    public WebElement selectStatus(){
        return adminRole_Status;
    }
    public WebElement setUsername() {return username;}
    public WebElement setPassword() {return password;}
    public WebElement setConfirmPassword() {return confirmPassword;}
    public WebElement clickSaveBtn(){
        return saveBtn;
    }

}
