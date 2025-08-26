package com.nopcommerce.users;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Random;

public class Level_01_Repeat_Yourself {
    private WebDriver driver;

    private String firtName, lastName, emailAdress, companyName, password;

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
    public void TC_01_register() {
        driver.findElement(By.cssSelector(".ico-register")).click();
        driver.findElement(By.cssSelector("#gender-male")).click();
        driver.findElement(By.cssSelector("#FirstName")).sendKeys(firtName);
        driver.findElement(By.cssSelector("#LastName")).sendKeys(lastName);
        driver.findElement(By.cssSelector("#Email")).sendKeys(emailAdress);
        driver.findElement(By.cssSelector("#Company")).sendKeys(companyName);
        driver.findElement(By.cssSelector("#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(password);
        driver.findElement(By.cssSelector("#register-button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");

    }

    @Test
    public void TC_02_login() {
        driver.findElement(By.cssSelector("ico-login")).click();

        driver.findElement(By.cssSelector("#Email")).sendKeys(emailAdress);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.cssSelector(".login-button")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='ico-account' and text()='My account']")).isDisplayed());
    }

    @Test
    public void myAccount() {
        driver.findElement(By.cssSelector("ico-account")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("#gender-male")).isSelected());
        Assert.assertEquals(driver.findElement(By.cssSelector("#FirstName")).getAttribute("value"), firtName);
        Assert.assertEquals(driver.findElement(By.cssSelector("#LastName")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.cssSelector("#Email")).getAttribute("value"), emailAdress);
        Assert.assertEquals(driver.findElement(By.cssSelector("#Company")).getAttribute("value"), companyName);
    }

    private int generateRandomNumber() {
        return new Random().nextInt(9999);
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
