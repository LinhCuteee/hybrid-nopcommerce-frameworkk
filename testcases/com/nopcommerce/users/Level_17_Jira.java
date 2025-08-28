package com.nopcommerce.users;

import commons.BaseTest;
import jiraConfigs.JiraCreateIssue;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.GeneratorPage;
import pageObjects.nopCommerce.Users.*;

public class Level_17_Jira extends BaseTest {
    //Pre_Condition
    @Parameters({"browser","userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl) {
        driver = getBrowserDriver(browserName, userUrl);

        firtName = "Linh";
        lastName = "xinh";
        emailAdress = "1205linhne" + generateRandomNumber() + "@gmail.com";
        companyName = "THHH";
        password = "123456789";

        homePage = GeneratorPage.getUserHomePage(driver);
    }

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void User_01_Register() {
        log.info("User_01_Register - Step 01: Open Register page");
        registorPage = homePage.openRegisterPage();

        log.info("User_01_Register - Step 02: Click to Male radio");
        registorPage.clickToMaleRadio();

        log.info("User_01_Register - Step 03: Enter to First name textbox with "+firtName);
        registorPage.enterToFirstNameTextbox(firtName);

        log.info("User_01_Register - Step 04: Enter to Last name textbox with "+lastName);
        registorPage.enterToLastNameTextbox(lastName);

        log.info("User_01_Register - Step 05: Enter to Email textbox with "+ emailAdress);
        registorPage.enterToEmailTextbox(emailAdress);

        log.info("User_01_Register - Step 06: Enter to Company name textbox with "+ companyName);
        registorPage.enterToCompanyNameTextbox(companyName);

        log.info("User_01_Register - Step 07: Enter to Password textbox with "+ password);
        registorPage.enterToPasswordTextbox(password);

        log.info("User_01_Register - Step 08: Enter to  cofirm Password textbox with "+ password);
        registorPage.enterToCofirmPasswordTextbox(password);

        log.info("User_01_Register - Step 09: Click to Register button");
        registorPage.clickToRegisterButton();

        log.info("User_01_Register - Step 10: Verify Success message is display");
        Assert.assertEquals(registorPage.getRegisterSuccessMessage(), "Your registration completed...");
    }

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void User_02_Login() {
        homePage = registorPage.openHomePage();

        loginPage = homePage.openLoginPage();

        homePage = loginPage.openHomePage(emailAdress, password);

        Assert.assertTrue(homePage.isMyAccountLinkDislayed());
    }

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void User_03_My_Account() {
        customerPage = homePage.openMyAccountPage();

        Assert.assertTrue(customerPage.isGenderMaleSelected());
        Assert.assertEquals(customerPage.getFirstNameTextboxValue(), firtName);
        Assert.assertEquals(customerPage.getLastNameTextboxvalue(), lastName);
        Assert.assertEquals(customerPage.getEmailTextboxValue(), emailAdress);
        Assert.assertEquals(customerPage.getCompanyTextboxValue(), companyName);
    }

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void User_04_Dynamic_Page() {
       //Ép kiểu tường minh từ BasePage sang kiểu UserAdressesPO
        adressesPage= (UserAdressesPO) customerPage.openSideBarLinkByPageName("Addresses");
        //.....

        orderPage = (UserOrderPO) adressesPage.openSideBarLinkByPageName("Orders");
        ///.......

        rewardPointPage = (UserRewardPointPO) orderPage.openSideBarLinkByPageName("Reward points");
        ///.....

        customerPage = (UserCustomerInfoPO) rewardPointPage.openSideBarLinkByPageName("Customer info");

        orderPage = (UserOrderPO) customerPage.openSideBarLinkByPageName("Orders");

    }

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void User_05_Dynamic_Page() {
/*        customerPage.openSideBarLinkByPageName("Addresses");
        adressesPage = GeneratorPage.getUserAdressesPage(driver);
        //.....

        adressesPage.openSideBarLinkByPageName("Orders");
        orderPage = GeneratorPage.getUserOrderPage(driver);
        ///.......*/

        orderPage.openSideBarLinkByPageName("Customer info");
        customerPage = GeneratorPage.getUserCustomerInforPage(driver);
        ///.....


        customerPage.openSideBarLinkByPageName("Addresses");
        adressesPage = GeneratorPage.getUserAdressesPage(driver);

        adressesPage.openSideBarLinkByPageName("Orders");
        orderPage = GeneratorPage.getUserOrderPage(driver);

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

    private String firtName, lastName, emailAdress, companyName, password;

}
