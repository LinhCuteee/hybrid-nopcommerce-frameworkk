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


public class Level_11_Data_Table extends BaseTest {
    private WebDriver driver;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver= getBrowserDriver(browserName,url);
        homePage = PageGenerator.getHomePage(driver);

    }


    @Test(enabled = false)
    public void Table_01_Paging() {
        //Navigation to any page(paging) in table
       /* homePage.openPageNumber("3");
        Assert.assertTrue(homePage.isPageNumberActived("3"));

        homePage.openPageNumber("10");
        Assert.assertTrue(homePage.isPageNumberActived("10"));

        homePage.openPageNumber("6");
        Assert.assertTrue(homePage.isPageNumberActived("6"));
*/
        homePage.openPageNumber("3");
        Assert.assertTrue(homePage.isPageNumberActive("3"));

        homePage.openPageNumber("8");
        Assert.assertTrue(homePage.isPageNumberActive("8"));

        homePage.openPageNumber("10");
        Assert.assertTrue(homePage.isPageNumberActive("10"));
    }

    @Test(enabled = false)
    public void Table_02_Search_And_Verify() {
        //Entor value to textbox
        homePage.enterToTextboxByHeaderName("12253515","Females");
        // veryfy
        Assert.assertTrue(homePage.isRowDataValueDisplay("12253515","AFRICA","12599691","24853148"));
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextboxByHeaderName("Angola","Country");
        Assert.assertTrue(homePage.isRowDataValueDisplay("276880","Angola","276472","553353"));
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextboxByHeaderName("25266","Males");
        Assert.assertTrue(homePage.isRowDataValueDisplay("24128","Albania","25266","49397"));
        homePage.refreshCurrentPage(driver);
    }
    @Test(enabled = false)
    public void Table_03_Delete() {
        //click delete button
        homePage.enterToTextboxByHeaderName("Angola","Country");
        homePage.deleteRowByCountryName("Angola");
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextboxByHeaderName("Armenia","Country");
        homePage.deleteRowByCountryName("Armenia");
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextboxByHeaderName("Aruba","Country");
        homePage.editRowByCountryName("Aruba");
        homePage.refreshCurrentPage(driver);
    }

    @Test
    public void Table_04_Action_By_Index() {
        homePage.openPageUrl(driver,"https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
        homePage.clickToLoadDataButton();
        homePage.enterToTextboxByIndex("1","Company","Viet nam");
        homePage.enterToTextboxByIndex("2","Contact Person","cds");
        homePage.enterToTextboxByIndex("3","Order Placed","9999");

        homePage.selectToDropdownByIndex("6","Country","Hong Kong");
        homePage.selectToDropdownByIndex("7","Country","Malaysia");

        homePage.checkToCheckboxByIndex("6","NPO?",true);
        homePage.checkToCheckboxByIndex("1","NPO?",false);

        homePage.clickToButtonByIndex("5","Insert");
        homePage.clickToButtonByIndex("1","Remove");
        homePage.clickToButtonByIndex("4","Move Up");
    }


    private HomePO homePage;

    @AfterClass
    public void AfterClass(){
        driver.quit();
    }

}