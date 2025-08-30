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

public class Level_19_Pattern_Object extends BaseTest {
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

    @Test
    public void User_01_Register() {
        homePage.clickToLinkTextByText(driver,"Register");
        registorPage = GeneratorPage.getUsertRegistorPage(driver);

        registorPage.clickToRadioByID(driver,"gender-male");

        registorPage.enterToTextboxByID(driver,firtName,"FirstName");
        registorPage.enterToTextboxByID(driver,lastName,"LastName");
        registorPage.enterToTextboxByID(driver,emailAdress,"Email");
        registorPage.enterToTextboxByID(driver,companyName,"Company");
        registorPage.enterToTextboxByID(driver,password,"Password");
        registorPage.enterToTextboxByID(driver,password,"ConfirmPassword");

        registorPage.clickToButtonByText(driver,"Register");

        Assert.assertEquals(registorPage.getRegisterSuccessMessage(), "Your registration completed");
    }

    @Test
    public void User_02_Login() {
        registorPage.clickToLinkTextByText(driver,"Log out");
        homePage=GeneratorPage.getUserHomePage(driver);
        homePage.clickToLinkTextByText(driver,"Log in");
        loginPage =GeneratorPage.getUserLoginPage(driver);
        loginPage.enterToTextboxByID(driver,emailAdress,"Email");
        loginPage.enterToTextboxByID(driver,password,"Password");
        loginPage.clickToButtonByText(driver,"Log in");
        homePage=GeneratorPage.getUserHomePage(driver);

        Assert.assertTrue(homePage.isMyAccountLinkDislayed());
    }

    @Test
    public void User_03_My_Account() {
        homePage.clickToLinkTextByText(driver,"My account");
        customerPage=GeneratorPage.getUserCustomerInforPage(driver);

        Assert.assertTrue(customerPage.isRadioByIDSelected(driver,"gender-male"));
        Assert.assertEquals(customerPage.getTextBoxAttributeValueByID(driver,"value","FirstName"),firtName);
        Assert.assertEquals(customerPage.getTextBoxAttributeValueByID(driver,"value","LastName"),lastName);
        Assert.assertEquals(customerPage.getTextBoxAttributeValueByID(driver,"value","Email"),emailAdress);
        Assert.assertEquals(customerPage.getTextBoxAttributeValueByID(driver,"value","Company"),companyName);
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
