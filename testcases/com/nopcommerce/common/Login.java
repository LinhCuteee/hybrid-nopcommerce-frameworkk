package com.nopcommerce.common;

import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.nopCommerce.GeneratorPage;
import pageObjects.nopCommerce.Users.*;

import java.util.Set;

public class Login extends BaseTest {
    @Parameters({"browser", "userUrl"})
    @BeforeTest
    public void beforeClass(String browserName, String userUrl) {
        driver = getBrowserDriver(browserName, userUrl);

        firtName = "Linh";
        lastName = "xinh";
        emailAdress = "1205linhne" + generateRandomNumber() + "@gmail.com";
        companyName = "THHH";
        password = "123456789";

        homePage = GeneratorPage.getUserHomePage(driver);
        homePage.clickToLinkTextByText(driver, "Register");
        registorPage = GeneratorPage.getUsertRegistorPage(driver);

        registorPage.clickToRadioByID(driver, "gender-male");

        registorPage.enterToTextboxByID(driver, firtName, "FirstName");
        registorPage.enterToTextboxByID(driver, lastName, "LastName");
        registorPage.enterToTextboxByID(driver, emailAdress, "Email");
        registorPage.enterToTextboxByID(driver, companyName, "Company");
        registorPage.enterToTextboxByID(driver, password, "Password");
        registorPage.enterToTextboxByID(driver, password, "ConfirmPassword");

        registorPage.clickToButtonByText(driver, "Register");

        Assert.assertEquals(registorPage.getRegisterSuccessMessage(), "Your registration completed");

        registorPage.clickToLinkTextByText(driver, "Log out");
        homePage = GeneratorPage.getUserHomePage(driver);
        homePage.clickToLinkTextByText(driver, "Log in");
        loginPage = GeneratorPage.getUserLoginPage(driver);
        loginPage.enterToTextboxByID(driver, emailAdress, "Email");
        loginPage.enterToTextboxByID(driver, password, "Password");
        loginPage.clickToButtonByText(driver, "Log in");
        homePage = GeneratorPage.getUserHomePage(driver);

        Assert.assertTrue(homePage.isMyAccountLinkDislayed());

        //Get cookie
        nopcommerceCookie = homePage.getAllCookie(driver);

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
    public static Set<Cookie> nopcommerceCookie;

    private String firtName, lastName, emailAdress, companyName, password;

}
