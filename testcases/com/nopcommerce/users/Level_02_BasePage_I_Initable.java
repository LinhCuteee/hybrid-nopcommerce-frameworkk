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

public class Level_02_BasePage_I_Initable {
    WebDriver driver;
    BasePage basePage; //declare

    String firtName, lastName, emailAdress, companyName, password;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        basePage = new BasePage(); //initial
        
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
        basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
        basePage.clickToElement(driver,"//a[@class='ico-register']");

        basePage.waitForElementClickable(driver,"//input[@id='gender-male']");
        basePage.clickToElement(driver,"//input[@id='gender-male']");

        basePage.senkeyToElement(driver,"//input[@id='FirstName']", firtName);
        basePage.senkeyToElement(driver,"//input[@id='LastName']", lastName);
        basePage.senkeyToElement(driver,"//input[@id='Email']", emailAdress);
        basePage.senkeyToElement(driver,"//input[@id='Company']", companyName);
        basePage.senkeyToElement(driver,"//input[@id='Password']", password);
        basePage.senkeyToElement(driver,"//input[@id='ConfirmPassword']", password);

        basePage.waitForElementClickable(driver,"//button[@id='register-button']");
        basePage.clickToElement(driver,"//button[@id='register-button']");

        Assert.assertEquals(basePage.getTextElement(driver,"//div[@class='result']"), "Your registration completed");

    }
    @Test
    public void TC_02_Login() {
        basePage.waitForElementClickable(driver,"//a[@class='ico-logout']");
        basePage.clickToElement(driver,"//a[@class='ico-logout']");

        basePage.waitForElementClickable(driver,"//a[@class='ico-login']");
        basePage.clickToElement(driver,"//a[@class='ico-login']");

        basePage.senkeyToElement(driver,"//input[@id='Email']",emailAdress);
        basePage.senkeyToElement(driver,"//input[@id='Password']",password);

        basePage.waitForElementClickable(driver,"//button[@class='button-1 login-button']");
        basePage.clickToElement(driver,"//button[@class='button-1 login-button']");

        basePage.isElementDisplay(driver,"//a[@class='ico-account' and text()='My account']");


    }

    @Test
    public void TC_03_MyAccount() {
        basePage.waitForElementClickable(driver,"//a[@class='ico-account']");
        basePage.clickToElement(driver,"//a[@class='ico-account']");

        Assert.assertTrue(basePage.iselementSelected(driver,"//input[@id='gender-male']"));

        Assert.assertEquals(basePage.getAttributeValue(driver,"//input[@id='FirstName']","value"),firtName);
        Assert.assertEquals(basePage.getAttributeValue(driver,"//input[@id='LastName']","value"),lastName);
        Assert.assertEquals(basePage.getAttributeValue(driver,"//input[@id='Email']","value"),emailAdress);
        Assert.assertEquals(basePage.getAttributeValue(driver,"//input[@id='Company']","value"),companyName);

    }

    private int generateRandomNumber() {
        return new Random().nextInt(9999);
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
