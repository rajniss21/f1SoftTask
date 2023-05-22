package Tests;

import Helpers.Hooks;
import PageObjects.*;
import org.testng.annotations.Test;

import static Helpers.Helper.prop;


public class AllTest extends Hooks {

    @Test
    // Add admin user
    public void testToAddAdminUser() throws InterruptedException{
        LandingPage landingPageObj = new LandingPage(driver);
        MM_AdminPage mmAdminPageObj =  new MM_AdminPage(driver);
        loginToTheModule();
        landingPageObj.clickAdminModule();
        mmAdminPageObj.clickAdminRole();
        mmAdminPageObj.selectEmployeeTextBox();
        Thread.sleep(3000);
        mmAdminPageObj.selectEmployee();

        mmAdminPageObj.clickStatusDropdown();
        mmAdminPageObj.selectStatus();

        mmAdminPageObj.setUsername(prop.getProperty("adminPageUserName"));
        mmAdminPageObj.setPassword(prop.getProperty("adminPagePassword"));
        mmAdminPageObj.setConfirmPassword(prop.getProperty("adminPageConfirmPassword"));
        mmAdminPageObj.clickSaveBtn();
    }

    @Test
    //Add PIM user
    public void testToAddPimUser() throws InterruptedException{
        LandingPage landingPageObj = new LandingPage(driver);
        MM_PIMPage mm_pimPageObj = new MM_PIMPage(driver);
        loginToTheModule();
        Thread.sleep(3000);

        landingPageObj.clickOnPIMModule();

        mm_pimPageObj.clickAddPimBtn();
        mm_pimPageObj.setFirstName(prop.getProperty("firstName"));
        mm_pimPageObj.setLastName(prop.getProperty("lastName"));
        Thread.sleep(2000);
        mm_pimPageObj.setSaveBtn();
        Thread.sleep(10000);
        mm_pimPageObj.getEmployeeName();

    }
    @Test
    public void testToAssertTheRequiredField() throws InterruptedException{
        LandingPage landingPageObj = new LandingPage(driver);
        LeavePage leavePageObj = new LeavePage(driver);

        loginToTheModule();

        landingPageObj.clickOnLeaveModule();
        leavePageObj.clickAssignLeaveTab();
        Thread.sleep(3000);
        leavePageObj.clickAssignBtn();
        Thread.sleep(2000);
        leavePageObj.getValidationText();
    }
    @Test
    public void testToAssertTheListOfBlocksPresent() throws InterruptedException{
        DashboardPage dashboardPageObj = new DashboardPage(driver);

        loginToTheModule();

        dashboardPageObj.getAllTextOfHeaders();


    }

    @Test
    public void deleteTest() throws InterruptedException{
       LandingPage landingPageObj = new LandingPage(driver);
       MM_AdminPage mmAdminPage = new MM_AdminPage(driver);

       loginToTheModule();
       landingPageObj.clickAdminModule();
       Thread.sleep(5000);
       mmAdminPage.clickDeleteBtn();


    }
}
