package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_BasePage_III_Inheritance extends BasePage{
    WebDriver driver;//declare

    String firtName, lastName, emailAdress, companyName, password;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        firtName = "Linh";
        lastName = "xinh";
        emailAdress = "1205linhne" + generateRandomNumber() + "@gmail.com";
        companyName = "THHH";
        password = "123456789";
    }

    @Test
    public void TC_01_Register() {
        waitForElementClickable(driver,"//a[@class='ico-register']");
        clickToElement(driver,"//a[@class='ico-register']");

        waitForElementClickable(driver,"//input[@id='gender-male']");
        clickToElement(driver,"//input[@id='gender-male']");

        senkeyToElement(driver,"//input[@id='FirstName']", firtName);
        senkeyToElement(driver,"//input[@id='LastName']", lastName);
        senkeyToElement(driver,"//input[@id='Email']", emailAdress);
        senkeyToElement(driver,"//input[@id='Company']", companyName);
        senkeyToElement(driver,"//input[@id='Password']", password);
        senkeyToElement(driver,"//input[@id='ConfirmPassword']", password);

        waitForElementClickable(driver,"//button[@id='register-button']");
        clickToElement(driver,"//button[@id='register-button']");

        Assert.assertEquals(getTextElement(driver,"//div[@class='result']"), "Your registration completed");

    }
    @Test
    public void TC_02_Login() {
        waitForElementClickable(driver,"//a[@class='ico-logout']");
        clickToElement(driver,"//a[@class='ico-logout']");

        waitForElementClickable(driver,"//a[@class='ico-login']");
        clickToElement(driver,"//a[@class='ico-login']");

        senkeyToElement(driver,"//input[@id='Email']",emailAdress);
        senkeyToElement(driver,"//input[@id='Password']",password);

        waitForElementClickable(driver,"//button[@class='button-1 login-button']");
        clickToElement(driver,"//button[@class='button-1 login-button']");

        isElementDisplay(driver,"//a[@class='ico-account' and text()='My account']");


    }

    @Test
    public void TC_03_MyAccount() {
        waitForElementClickable(driver,"//a[@class='ico-account']");
        clickToElement(driver,"//a[@class='ico-account']");

        Assert.assertTrue(iSelementSelected(driver,"//input[@id='gender-male']"));

        Assert.assertEquals(getAttributeValue(driver,"//input[@id='FirstName']","value"),firtName);
        Assert.assertEquals(getAttributeValue(driver,"//input[@id='LastName']","value"),lastName);
        Assert.assertEquals(getAttributeValue(driver,"//input[@id='Email']","value"),emailAdress);
        Assert.assertEquals(getAttributeValue(driver,"//input[@id='Company']","value"),companyName);

    }

    private int generateRandomNumber() {
        return new Random().nextInt(9999);
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
