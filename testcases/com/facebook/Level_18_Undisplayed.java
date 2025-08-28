package com.facebook;

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
import pageObjects.facebook.GeneraterPage;
import pageObjects.facebook.LoginPO;
import pageObjects.nopCommerce.GeneratorPage;
import pageObjects.nopCommerce.Users.*;

public class Level_18_Undisplayed extends BaseTest {
    //Pre_Condition
    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName,url);
        loginPage = GeneraterPage.getLoginPage(driver);
    }

    @Test
    public void TC_01_Element_Undisplayed(){
        loginPage.clickToNewAccountButton();

        //Case 01: Verify Comfirm Email Adress is displayed
        loginPage.EnterToEmailAddressTextbox("linh@gmail.com");
        Assert.assertTrue(loginPage.isComfirmEmailTextboxDispalyed());

        //Case 02: Verify Comfirm Email Adress is not displayed(present)
        loginPage.EnterToEmailAddressTextbox("");
        Assert.assertFalse(loginPage.isComfirmEmailTextboxDispalyed());

        //Case 03: Verify Comfirm Email Adress is not displayed(non-present)
        loginPage.clickToCloseIcon();
        Assert.assertTrue(loginPage.isComfirmEmailTextboxUndispalyed());

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    //Declare variable
    private WebDriver driver;
    private LoginPO loginPage;


    private String firtName, lastName, emailAdress, companyName, password;

}
