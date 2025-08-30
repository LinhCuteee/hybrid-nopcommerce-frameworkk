package com.nopcommerce.users;

import com.nopcommerce.common.Login;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.GeneratorPage;
import pageObjects.nopCommerce.Users.*;

public class Level_20_Share_State extends BaseTest {
    //Pre_Condition
    @Parameters({"browser","userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl) {
        driver = getBrowserDriver(browserName, userUrl);

        firtName = "Linh";
        lastName = "xinh";
        companyName = "THHH";
        password = "123456789";

        homePage = GeneratorPage.getUserHomePage(driver);

        //set Cookie
        homePage.setCookie(driver, Login.nopcommerceCookie);
        driver.navigate().refresh();

        Assert.assertTrue(homePage.isMyAccountLinkDislayed());
    }
    @Test
    public void User_03_My_Account() {
        homePage.clickToLinkTextByText(driver,"My account");
        customerPage=GeneratorPage.getUserCustomerInforPage(driver);

        Assert.assertTrue(customerPage.isRadioByIDSelected(driver,"gender-male"));
        Assert.assertEquals(customerPage.getTextBoxAttributeValueByID(driver,"value","FirstName"),firtName);
        Assert.assertEquals(customerPage.getTextBoxAttributeValueByID(driver,"value","LastName"),lastName);
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
