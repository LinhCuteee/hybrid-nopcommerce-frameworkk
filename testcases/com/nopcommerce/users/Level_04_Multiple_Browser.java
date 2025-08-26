package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.Users.UserCustomerInfoPO;
import pageObjects.nopCommerce.Users.UserHomePO;
import pageObjects.nopCommerce.Users.UserLoginPO;
import pageObjects.nopCommerce.Users.UserRegisterPO;

public class Level_04_Multiple_Browser extends BaseTest {
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

        homePage = new UserHomePO(driver);
    }

    @Test
    public void User_01_Register() {
        homePage.openRegisterPage();

        //Từ Home Page qua Register Page
        //Page đó đc sinh ra và bắt đầu làm những action của Page đó
        registorPage = new UserRegisterPO(driver);

        registorPage.clickToMaleRadio();
        registorPage.enterToFirstNameTextbox(firtName);
        registorPage.enterToLastNameTextbox(lastName);
        registorPage.enterToEmailTextbox(emailAdress);
        registorPage.enterToCompanyNameTextbox(companyName);
        registorPage.enterToPasswordTextbox(password);
        registorPage.enterToCofirmPasswordTextbox(password);
        registorPage.clickToRegisterButton();

        Assert.assertEquals(registorPage.getRegisterSuccessMessage(),"Your registration completed");


    }

    @Test
    public void User_02_Login() {
        registorPage.openHomePage();
        homePage = new UserHomePO(driver);
        homePage.openLoginPage();

        loginPage = new UserLoginPO(driver);
        loginPage.enterToEmailTextbox(emailAdress);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();

        homePage = new UserHomePO(driver);
        Assert.assertTrue(homePage.isMyAccountLinkDislayed());
    }

    @Test
    public void User_03_My_Account() {
        homePage.openMyAccountPage();

        customerPage = new UserCustomerInfoPO(driver);
        Assert.assertTrue(customerPage.isGenderMaleSelected());
        Assert.assertEquals(customerPage.getFirstNameTextboxValue(),firtName);
        Assert.assertEquals(customerPage.getLastNameTextboxvalue(),lastName);
        Assert.assertEquals(customerPage.getEmailTextboxValue(),emailAdress);
        Assert.assertEquals(customerPage.getCompanyTextboxValue(),companyName);
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

    private String firtName, lastName, emailAdress, companyName, password;

}
