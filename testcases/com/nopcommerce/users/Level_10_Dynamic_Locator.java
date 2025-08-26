package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.GeneratorPage;
import pageObjects.nopCommerce.Users.*;

public class Level_10_Dynamic_Locator extends BaseTest {
    //Pre_Condition
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        firtName = "Linh";
        lastName = "xinh";
        emailAdress = "1205linhne" + generateRandomNumber() + "@gmail.com";
        companyName = "THHH";
        password = "123456789";

        homePage = GeneratorPage.getUserHomePage(driver);
    }

    @Test
    public void User_01_Register() {
        registorPage = homePage.openRegisterPage();

        registorPage.clickToMaleRadio();
        registorPage.enterToFirstNameTextbox(firtName);
        registorPage.enterToLastNameTextbox(lastName);
        registorPage.enterToEmailTextbox(emailAdress);
        registorPage.enterToCompanyNameTextbox(companyName);
        registorPage.enterToPasswordTextbox(password);
        registorPage.enterToCofirmPasswordTextbox(password);
        registorPage.clickToRegisterButton();

        Assert.assertEquals(registorPage.getRegisterSuccessMessage(), "Your registration completed");


    }

    @Test
    public void User_02_Login() {
        homePage = registorPage.openHomePage();

        loginPage = homePage.openLoginPage();

        homePage = loginPage.openHomePage(emailAdress, password);

        Assert.assertTrue(homePage.isMyAccountLinkDislayed());
    }

    @Test
    public void User_03_My_Account() {
        customerPage = homePage.openMyAccountPage();

        Assert.assertTrue(customerPage.isGenderMaleSelected());
        Assert.assertEquals(customerPage.getFirstNameTextboxValue(), firtName);
        Assert.assertEquals(customerPage.getLastNameTextboxvalue(), lastName);
        Assert.assertEquals(customerPage.getEmailTextboxValue(), emailAdress);
        Assert.assertEquals(customerPage.getCompanyTextboxValue(), companyName);
    }

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
