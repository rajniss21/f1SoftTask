package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

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

    @FindBy(xpath = "(//div[@class='oxd-table-cell oxd-padding-cell']/div/button[1])[2]")
    WebElement deleteBtn;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span']")
    WebElement totalNumberOfRecordsFound;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
    WebElement areYouSure;

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
        public void setUsername (String adminPageUserName) {username.sendKeys(adminPageUserName);}
        public void setPassword (String adminPagePassword) {password.sendKeys(adminPagePassword);}
        public void setConfirmPassword (String adminPageConfirmPassword) {confirmPassword.sendKeys(adminPageConfirmPassword);}
        public void clickSaveBtn () {saveBtn.click();}

        public void clickDeleteBtn() throws InterruptedException{

        String numberOfRecordsText = totalNumberOfRecordsFound.getText();
        String[] numberOfRecordsInArray = numberOfRecordsText.split("Records");
        String numberStarting = numberOfRecordsInArray[0].replaceAll("[^0-9]","");
        int number = Integer.parseInt(numberStarting);

        for (int i = 0 ; i <=number ; i++){
            if(deleteBtn.isDisplayed()){
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,200)");
                //Thread.sleep(3000);
                deleteBtn.click();
                Thread.sleep(2000);
                areYouSure.click();
               Thread.sleep(5000);
            }else {
                System.out.println("Delete button not displayed");
                break;
            }
        }

        }


    }

