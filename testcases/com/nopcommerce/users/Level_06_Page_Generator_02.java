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

public class Level_06_Page_Generator_02 extends BaseTest {
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
        //Trong HomePage click link sẽ chuyển đến RegisterPage
        //Có sự kết nối giữ 2 page
        //Không bị phạm nguyên tắc encapsulatio( khởi tại đối tượng trong class khác)
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
