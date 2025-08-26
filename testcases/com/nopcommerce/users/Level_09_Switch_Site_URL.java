package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.Admin.AdminDashboardPO;
import pageObjects.nopCommerce.Admin.AdminLoginPO;
import pageObjects.nopCommerce.GeneratorPage;
import pageObjects.nopCommerce.Users.*;

public class Level_09_Switch_Site_URL extends BaseTest {
    //Pre_Condition
    @Parameters({"browser", "userUrl", "adminUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl) {
        this.userUrl = userUrl;
        this.adminUrl = adminUrl;

        driver = getBrowserDriver(browserName, this.userUrl);
        userHomePage = GeneratorPage.getUserHomePage(driver);
        firtName = "Linh";
        lastName = "xinh";
        emailAdress = "1205linhne" + generateRandomNumber() + "@gmail.com";
        companyName = "THHH";
        password = "123456789";
        adminEmail = "admin@yourstore.com";
        adminPassword = "admin";

        userRegistorPage = userHomePage.openRegisterPage();

        userRegistorPage.clickToMaleRadio();
        userRegistorPage.enterToFirstNameTextbox(firtName);
        userRegistorPage.enterToLastNameTextbox(lastName);
        userRegistorPage.enterToEmailTextbox(emailAdress);
        userRegistorPage.enterToCompanyNameTextbox(companyName);
        userRegistorPage.enterToPasswordTextbox(password);
        userRegistorPage.enterToCofirmPasswordTextbox(password);
        userRegistorPage.clickToRegisterButton();

        Assert.assertEquals(userRegistorPage.getRegisterSuccessMessage(), "Your registration completed");

    }

    @Test
    public void Role_01_User_Site_To_Admin_Site() {
        userHomePage = userRegistorPage.openHomePage();

        userLoginPage = userHomePage.openLoginPage();

        userHomePage = userLoginPage.openHomePage(emailAdress, password);

        Assert.assertTrue(userHomePage.isMyAccountLinkDislayed());

        //Step order 1 product nao do ...

        // Qua trang admin de xac nhan don
        userHomePage.openPageUrl(driver, this.adminUrl);
        //Khoi tao Login Page Admin
        adminLoginPage = GeneratorPage.getAdminLoginPage(driver);

        adminLoginPage.entorToEmailTextbox(adminEmail);
        adminLoginPage.enterToPasswordTextbox(adminPassword);
        adminDashboardPage = adminLoginPage.clickToLoginButton();
    }

    @Test
    public void Role_02_Admin_Site_To_User_Site() {
        //Vao trang Order,Customer
        adminDashboardPage.openPageUrl(driver,this.userUrl);
        userHomePage = GeneratorPage.getUserHomePage(driver);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    //Declare variable
    private WebDriver driver;
    private UserHomePO userHomePage;
    private UserRegisterPO userRegistorPage;
    private UserLoginPO userLoginPage;
    private UserCustomerInfoPO userCustomerPage;
    private UserRewardPointPO userRewardPointPage;
    private UserOrderPO userOrderPage;
    private UserAdressesPO userAdressesPage;
    private AdminDashboardPO adminDashboardPage;
    private AdminLoginPO adminLoginPage;
    private String firtName, lastName, emailAdress, companyName, password;

    private String adminEmail, adminPassword;
    private String userUrl, adminUrl;

}
