package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MM_AdminPage {
    public WebDriver driver;

    public MM_AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
    @FindBy(xpath = "//div[@role='option']")
    WebElement selectEmployee;

    public void selectEmployee() {
        selectEmployee.click();
    }

    public void clickAdminRole() {
        adminRole_Status.click();
    }

    public void clickUserAddBtn() {
        userAddBtn.click();
    }

    public void selectUserRole() {
        userRole.click();
    }

    public void selectEmployeeTextBox() {
        employeeNameTextBox.sendKeys("Charlie  Carter");;
    }

    public void clickStatusDropdown() {status.click();}
        public void selectStatus () {adminRole_Status.click();}
        public void setUsername () {username.sendKeys("rajnish");}
        public void setPassword () {password.sendKeys("Admin123@");}
        public void setConfirmPassword () {confirmPassword.sendKeys("Admin123@");}
        public void clickSaveBtn () {saveBtn.click();}

    }
}
