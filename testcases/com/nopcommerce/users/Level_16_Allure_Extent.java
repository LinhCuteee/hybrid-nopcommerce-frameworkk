package com.nopcommerce.users;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.GeneratorPage;
import pageObjects.nopCommerce.Users.*;
import reportConfigs.ExtentManager;

import java.lang.reflect.Method;

@Feature("User")
public class Level_16_Allure_Extent extends BaseTest {
    //Pre_Condition
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        this.browserName=browserName.toUpperCase();

        firtName = "Linh";
        lastName = "xinh";
        emailAdress = "1205linhne" + generateRandomNumber() + "@gmail.com";
        companyName = "THHH";
        password = "123456789";

        homePage = GeneratorPage.getUserHomePage(driver);
    }

    @Description("Registor to application")
    @Severity(SeverityLevel.BLOCKER)
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

        Assert.assertEquals(registorPage.getRegisterSuccessMessage(), "Your registration completed...");
    }

    @Description("Login to application")
    @Severity(SeverityLevel.CRITICAL)
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

    private String firtName, lastName, emailAdress, companyName, password;

}
