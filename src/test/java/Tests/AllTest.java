package Tests;

import Helpers.Hooks;
import PageObjects.*;
import org.testng.annotations.Test;


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

        mmAdminPageObj.setUsername();

        mmAdminPageObj.setPassword();
        mmAdminPageObj.setConfirmPassword();
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
        mm_pimPageObj.setFirstName();
        mm_pimPageObj.setLastName();
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
}
