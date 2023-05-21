package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage {

    public WebDriver driver;

    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget']")
    List<WebElement> blocks;


}
