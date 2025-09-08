package com.orangeHRM.pim;

import commons.BaseTest;
import jdk.jfr.Threshold;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangeHRM.PageGenerater;
import pageObjects.nopCommerce.GeneratorPage;
import pageObjects.orangeHRM.LoginPO;
import pageObjects.orangeHRM.pim.DashboardPO;
import pageObjects.orangeHRM.pim.employee.AddNewEmployeePO;
import pageObjects.orangeHRM.pim.employee.ContactDetailPO;
import pageObjects.orangeHRM.pim.employee.EmployeeListPO;
import pageObjects.orangeHRM.pim.employee.PersonalDetailPO;

public class PM_01_Employee extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private AddNewEmployeePO addNewEmployeePage;
    private ContactDetailPO contactDetailPage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailPO personalDetailPage;
    private String employeeID, firstName, lastName, editFirstName, editLastName;
    private String driverLicenseNumber, licenseExpiryDate, nationality, maritalStatus, dateOfBirth, gender;
    private String picture = "anh.jpg";


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browser, String url) {
        driver = getBrowserDriver(browser, url);
        loginPage = PageGenerater.getLoginPage(driver);

        firstName = "John";
        lastName = "Wick";
        editFirstName = "Phuong";
        editLastName = "Anh";
        driverLicenseNumber = "012345678";
        licenseExpiryDate = "2030-10-10";
        nationality = "Vietnamese";
        maritalStatus = "Single";
        dateOfBirth = "2025-02-02";
        gender = "Male";

        loginPage.enterToUserNameTextbox("automationfc");
        loginPage.enterToPasswordTextbox("0Qbw8J(&ist$jHH&q*");
        dashboardPage = loginPage.clikToLoginButton();

    }

    @Test
    public void Employee_01_Add_New_Employee() {
        employeeListPage = dashboardPage.clickToPIMPage();
        addNewEmployeePage = employeeListPage.clickToAddEmployeeButton();
        addNewEmployeePage.enterToFirtNameTextbox(firstName);
        addNewEmployeePage.enterToLastNameTextbox(lastName);
        employeeID = addNewEmployeePage.getEmploueeId("value");
        personalDetailPage = addNewEmployeePage.clickToSaveButtonAtAddEmployee();
    }

    @Test
    public void Employee_02_Upload_Avatar() {
        personalDetailPage.clickToEmployeeAvatarImage();

        Dimension beforeAvatarSize = personalDetailPage.getAvatarSize();

        personalDetailPage.uploadMultipleFiles(driver, picture);

        personalDetailPage.clickToSaveAtChangeProfilePictrue();

        Assert.assertTrue(personalDetailPage.isSuccessMesaagerDisplayed(driver));

        personalDetailPage.waitAllIconInVisible(driver);

        Assert.assertTrue(personalDetailPage.isProfileAvatarUploadSuccessed(beforeAvatarSize));

    }

    @Test
    public void Employee_03_Personal_Details() throws InterruptedException {
        personalDetailPage.openPersionalDetailPage();
        personalDetailPage.enterToFirstNameTextbox(editFirstName);
        personalDetailPage.enterToLastNameTextbox(editLastName);

        Assert.assertEquals(personalDetailPage.getEmployeeID("value"), employeeID);

        personalDetailPage.enterToDriverLicenerTextbox(driverLicenseNumber);
        personalDetailPage.enterToLicenseExpiryTextbox(licenseExpiryDate);
        personalDetailPage.selectToNationalityDropdown(nationality);
        personalDetailPage.selectToMaritalStatusDropdown(maritalStatus);
        personalDetailPage.enterToDateOfBirthTextbox(dateOfBirth);
        personalDetailPage.selectGenderRadioButton(gender);
        personalDetailPage.clickToSaveButton();
        Assert.assertTrue(personalDetailPage.isSuccessMesaagerDisplayed(driver));

        personalDetailPage.waitAllIconInVisible(driver);

        //verify
        Assert.assertEquals(personalDetailPage.getFirstNameTextboxValue("value"),editFirstName);
        Assert.assertEquals(personalDetailPage.getLastNameTextboxValue("value"),editLastName);
        Assert.assertEquals(personalDetailPage.getEmployeeID("value"), employeeID);
        Assert.assertEquals(personalDetailPage.getDriverLicenerTextboxValue("value"),driverLicenseNumber);
        Assert.assertEquals(personalDetailPage.getLicenerExpityTextboxValue("value"),licenseExpiryDate);
        Assert.assertEquals(personalDetailPage.getNationalityDropdownValue(),nationality);
        Assert.assertEquals(personalDetailPage.getMaritalStatusDropdownValue(),maritalStatus);
        Assert.assertEquals(personalDetailPage.getDateOfBirthTextboxValue("value"),dateOfBirth);
        Assert.assertTrue(personalDetailPage.isGenderRadioButtonSelected(gender));



    }

    @Test
    public void Employee_04_Contac_Details() {

    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
}
