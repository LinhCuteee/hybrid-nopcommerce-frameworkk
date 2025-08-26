package com.jquery.cases;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jQuery.HomePO;
import pageObjects.jQuery.PageGenerator;


public class Level_12_Upload_File extends BaseTest {
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver= getBrowserDriver(browserName,url);
        homePage = PageGenerator.getHomePage(driver);
        hanoi="HN.jpg";
        hcm="HCM.jpg";
        bacninh="BN.jpg";

    }


    @Test
    public void Upload_01() {
        homePage.uploadMultipleFiles(driver,hanoi,hcm,bacninh);
        homePage.sleepInSecond(3);

        //verify file loaded thanh cong
        Assert.assertTrue(homePage.isFileLoadedByName(hanoi));
        Assert.assertTrue(homePage.isFileLoadedByName(hcm));
        Assert.assertTrue(homePage.isFileLoadedByName(bacninh));

        homePage.clickToSatrt();

        //verify file uploaded thanh cong
        Assert.assertTrue(homePage.isFileUpLoadedByName(hanoi));
        Assert.assertTrue(homePage.isFileUpLoadedByName(hcm));
        Assert.assertTrue(homePage.isFileUpLoadedByName(bacninh));
    }

    @Test
    public void Table_02_Search_And_Verify() {


    }


    private WebDriver driver;
    private HomePO homePage;
    private String hanoi, hcm, bacninh;

    @AfterClass
    public void AfterClass(){
        driver.quit();
    }

}