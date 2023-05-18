package Tests;

import Helpers.Hooks;
import PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AllTest extends Hooks {

    @Test
    // Add admin user
    public void testToAddAdminUser() throws InterruptedException{
        LandingPage landingPageObj = new LandingPage(driver);
        MM_AdminPage mmAdminPageObj =  new MM_AdminPage(driver);
        loginToTheModule();

        waitForThisTobeClickable(landingPageObj.clickAdminModule());
        landingPageObj.clickAdminModule().click();

        waitForThisTobeClickable(mmAdminPageObj.clickUserAddBtn());
        mmAdminPageObj.clickUserAddBtn().click();

        waitForThisTobeClickable(mmAdminPageObj.selectUserRole());
        mmAdminPageObj.selectUserRole().click();
        mmAdminPageObj.clickAdminRole().click();

        mmAdminPageObj.selectEmployeeTextBox().sendKeys("Charlie  Carter");
        Thread.sleep(3000);
        mmAdminPageObj.selectEmployee().click();

        waitForElementToBeVisible(mmAdminPageObj.clickStatusDropdown());
        mmAdminPageObj.clickStatusDropdown().click();
        mmAdminPageObj.selectStatus().click();

        mmAdminPageObj.setUsername().sendKeys("rajnish");

        mmAdminPageObj.setPassword().sendKeys("Admin123@");
        mmAdminPageObj.setConfirmPassword().sendKeys("Admin123@");
        mmAdminPageObj.clickSaveBtn().click();
    }

    @Test
    //Add PIM user
    public void testToAddPimUser() throws InterruptedException{
        LandingPage landingPageObj = new LandingPage(driver);
        MM_PIMPage mm_pimPageObj = new MM_PIMPage(driver);
        loginToTheModule();
        Thread.sleep(3000);
        waitForThisTobeClickable(landingPageObj.clickOnPIMModule());
        landingPageObj.clickOnPIMModule().click();
        waitForThisTobeClickable(mm_pimPageObj.clickAddPimBtn());
        mm_pimPageObj.clickAddPimBtn().click();
        waitForThisTobeClickable(mm_pimPageObj.setFirstName());
        mm_pimPageObj.setFirstName().sendKeys("Rajnish");
        waitForThisTobeClickable(mm_pimPageObj.setLastName());
        mm_pimPageObj.setLastName().sendKeys("Pradhan");
        Thread.sleep(2000);
        jsClickExecuter(mm_pimPageObj.setSaveBtn());
        Thread.sleep(10000);
        waitForThisTobeClickable(mm_pimPageObj.getEmployeeName());
        Assert.assertEquals(mm_pimPageObj.getEmployeeName().getText(),"Rajnish Pradhan");
    }
    @Test
    public void testToAssertTheRequiredField() throws InterruptedException{
        LandingPage landingPageObj = new LandingPage(driver);
        LeavePage leavePageObj = new LeavePage(driver);
        loginToTheModule();
        waitForThisTobeClickable(landingPageObj.clickOnLeaveModule());
        landingPageObj.clickOnLeaveModule().click();
        waitForThisTobeClickable(leavePageObj.clickAssignLeaveTab());
        leavePageObj.clickAssignLeaveTab().click();
        waitForThisTobeClickable(leavePageObj.clickAssignBtn());
        Thread.sleep(3000);
        leavePageObj.clickAssignBtn().click();
        Thread.sleep(2000);
        String validationMessage = leavePageObj.getValidationText();
        Assert.assertEquals("Required", validationMessage);
        System.out.println("The actual text is " + validationMessage);
    }
}
