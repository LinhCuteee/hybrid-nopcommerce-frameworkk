package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.CustomerInfoPageFactory;
import pageFactory.HomePageFactory;
import pageFactory.LoginPageFactory;
import pageFactory.RegistorPageFactory;

public class Level_05_Page_Factory extends BaseTest {
    //Pre_Condition
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
      driver= getBrowserDriver(browserName);

        firtName = "Linh";
        lastName = "xinh";
        emailAdress = "1205linhne" + generateRandomNumber() + "@gmail.com";
        companyName = "THHH";
        password = "123456789";

        homePage = new HomePageFactory(driver);
    }

    @Test
    public void User_01_Register() {
        homePage.clickToRegisterLink();

        //Từ Home Page qua Register Page
        //Page đó đc sinh ra và bắt đầu làm những action của Page đó
        registorPage = new RegistorPageFactory(driver);

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
        registorPage.clickToLogOutLink();
        homePage = new HomePageFactory(driver);
        homePage.clickToLoginLink();

        loginPage = new LoginPageFactory(driver);
        loginPage.enterToEmailTextbox(emailAdress);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();

        homePage = new HomePageFactory(driver);
        Assert.assertTrue(homePage.isMyAccountLinkDislayed());
    }

    @Test
    public void User_03_My_Account() {
        homePage.clickToMyAccountLink();

        customerPage = new CustomerInfoPageFactory(driver);
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
    private HomePageFactory homePage;
    private RegistorPageFactory registorPage;
    private LoginPageFactory loginPage;
    private CustomerInfoPageFactory customerPage;

    private String firtName, lastName, emailAdress, companyName, password;

}
