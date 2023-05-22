package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class DashboardPage {

    public WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='orangehrm-dashboard-widget-header']")
    List<WebElement> blocks;

    String[] blocksHeader = {"Time at WorkS","My Actions","Quick Launch","Buzz Latest Posts","Employees on Leave Today","Employee Distribution by Sub Unit","Employee Distribution by Location"};

    public void getAllTextOfHeaders(){
        int index = 0;
        for (WebElement element: blocks) {
            System.out.println(element.getText());

            try {
                SoftAssert softAssert = new SoftAssert();
                softAssert.assertEquals(element.getText(),blocksHeader[index]);
                softAssert.assertAll();
            }catch (AssertionError error){
                System.out.println("---" + error.getMessage());
            }
        }
        }
}


