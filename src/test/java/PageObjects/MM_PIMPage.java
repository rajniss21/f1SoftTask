package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MM_PIMPage {
    public WebDriver driver;
    public MM_PIMPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement AddPimBtn;
    @FindBy(xpath = "//input[@name='firstName']")
    WebElement FirstName;
    @FindBy(xpath = "//input[@name='lastName']")
    WebElement LastName;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement SaveBtn;
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 --strong']")
    WebElement employeeName;
    public void clickAddPimBtn(){
        AddPimBtn.click();
    }
   public void setFirstName(){
        FirstName.sendKeys("Rajnish");
   }
   public void setLastName(){LastName.sendKeys("Pradhan");
   }
   public void setSaveBtn(){SaveBtn.click();}
   public  void getEmployeeName(){
       String actualTitle =  employeeName.getText();
       String expectedTitle = "Rajnish Pradhan";
       Assert.assertEquals(expectedTitle, actualTitle);
    }
}