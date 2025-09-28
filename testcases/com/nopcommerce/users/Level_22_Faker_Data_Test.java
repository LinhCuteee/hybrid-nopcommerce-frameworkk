package com.nopcommerce.users;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.GeneratorPage;
import pageObjects.nopCommerce.Users.*;
import reportConfigs.ExtentManager;
import utilities.FakerConfig;

import java.lang.reflect.Method;

public class Level_22_Faker_Data_Test extends BaseTest {
    //Pre_Condition
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        this.browserName=browserName.toUpperCase();

        fakerConfig = FakerConfig.getFaker();

        firtName = fakerConfig.getFirstName();
        lastName = fakerConfig.getLastName();
        emailAdress = fakerConfig.getEmailAddress();
        companyName = fakerConfig.getCompany();
        password = fakerConfig.getPassword();

        homePage = GeneratorPage.getUserHomePage(driver);
    }

    @Test
    public void User_01_Register(Method method) {
        ExtentManager.startTest(method.getName()+ "-" + "Run on "+ browserName, "User_01_Register");
        ExtentManager.getTest().log(Status.INFO,"User_01_Register - Step 01: Open Register page");
        registorPage = homePage.openRegisterPage();

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - Step 02: Click to Male radio");
        registorPage.clickToMaleRadio();

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - Step 03: Enter to First name textbox with "+firtName);
        registorPage.enterToFirstNameTextbox(firtName);

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - Step 04: Enter to Last name textbox with "+lastName);
        registorPage.enterToLastNameTextbox(lastName);

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - Step 05: Enter to Email textbox with "+ emailAdress);
        registorPage.enterToEmailTextbox(emailAdress);

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - Step 06: Enter to Company name textbox with "+ companyName);
        registorPage.enterToCompanyNameTextbox(companyName);

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - Step 07: Enter to Password textbox with "+ password);
        registorPage.enterToPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - Step 08: Enter to  cofirm Password textbox with "+ password);
        registorPage.enterToCofirmPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - Step 09: Click to Register button");
        registorPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - Step 10: Verify Success message is display");
        Assert.assertEquals(registorPage.getRegisterSuccessMessage(), "Your registration completed...");
    }

    @Test
    public void User_02_Login(Method method) {
        ExtentManager.startTest(method.getName()+ "-" + "Run on "+ browserName, "User_02_Login");
        ExtentManager.getTest().log(Status.INFO,"User_02_Login - Step 01: Open Home page");
        homePage = registorPage.openHomePage();

        ExtentManager.getTest().log(Status.INFO,"User_02_Login - Step 02: Open Login page");
        loginPage = homePage.openLoginPage();

        ExtentManager.getTest().log(Status.INFO,"User_02_Login - Step 03: Open Home page");
        homePage = loginPage.openHomePage(emailAdress, password);

        ExtentManager.getTest().log(Status.INFO,"User_02_Login - Step 04: Verify My Account link is display");
        Assert.assertTrue(homePage.isMyAccountLinkDislayed());
    }

    @Test
    public void User_03_My_Account(Method method) {
        ExtentManager.startTest(method.getName()+ "-" + "Run on "+browserName, "User_03_My_Account");
        customerPage = homePage.openMyAccountPage();

        Assert.assertTrue(customerPage.isGenderMaleSelected());
        Assert.assertEquals(customerPage.getFirstNameTextboxValue(), firtName);
        Assert.assertEquals(customerPage.getLastNameTextboxvalue(), lastName);
        Assert.assertEquals(customerPage.getEmailTextboxValue(), emailAdress);
        Assert.assertEquals(customerPage.getCompanyTextboxValue(), companyName);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    //Declare variable
    private WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registorPage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerPage;
    private UserRewardPointPO rewardPointPage;
    private UserOrderPO orderPage;
    private UserAdressesPO adressesPage;
    private String browserName;

    private FakerConfig fakerConfig;

    private String firtName, lastName, emailAdress, companyName, password;

}
