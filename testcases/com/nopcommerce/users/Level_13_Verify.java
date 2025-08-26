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

public class Level_13_Verify extends BaseTest {
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
        //Step 01 Asseer
        verifyEquals(registorPage.getRegistorPageTitle(), "reGister");
        registorPage.clickToMaleRadio();
        registorPage.enterToFirstNameTextbox(firtName);
        registorPage.enterToLastNameTextbox(lastName);
        registorPage.enterToEmailTextbox(emailAdress);
        registorPage.enterToCompanyNameTextbox(companyName);
        registorPage.enterToPasswordTextbox(password);
        registorPage.enterToCofirmPasswordTextbox(password);
        registorPage.clickToRegisterButton();
        //Step 01 Asseer
        verifyEquals(registorPage.getRegisterSuccessMessage(), "Your regisfdghajklstration completed");


    }

    @Test
    public void User_02_Login() {
        homePage = registorPage.openHomePage();

        loginPage = homePage.openLoginPage();

        homePage = loginPage.openHomePage(emailAdress, password);

        verifyTrue(homePage.isMyAccountLinkDislayed());
    }

    @Test
    public void User_03_My_Account() {
        customerPage = homePage.openMyAccountPage();

        verifyTrue(customerPage.isGenderMaleSelected());
        verifyEquals(customerPage.getFirstNameTextboxValue(), firtName);
        verifyEquals(customerPage.getLastNameTextboxvalue(), lastName);
        verifyEquals(customerPage.getEmailTextboxValue(), emailAdress);
        verifyEquals(customerPage.getCompanyTextboxValue(), companyName);
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
