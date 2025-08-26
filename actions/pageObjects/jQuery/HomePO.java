package pageObjects.jQuery;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jQuery.HomePageUI;

import java.util.List;

public class HomePO extends BasePage {
    private WebDriver driver;
    public HomePO(WebDriver driver){
        this.driver=driver;
    }

    public void openPageNumber(String pageNumber) {
        waitForElementVisible(driver,HomePageUI.DYNAMIC_PAGE_LINK,pageNumber);
        clickToElement(driver,HomePageUI.DYNAMIC_PAGE_LINK,pageNumber);
    }

    public boolean isPageNumberActive(String pageNumber) {
        waitForElementVisible(driver,HomePageUI.DYNAMIC_PAGE_LINK,pageNumber);
       return getAttributeValue(driver,HomePageUI.DYNAMIC_PAGE_LINK,"class",pageNumber).endsWith("active");
    }

    public void enterToTextboxByHeaderName(String valueToSenkey, String headerName) {
        waitForElementVisible(driver,HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME,headerName);
        senkeyToElement(driver,HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME,valueToSenkey,headerName);
        sendKeybroadToElement(driver,HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, Keys.ENTER,headerName);
    }

    public boolean isRowDataValueDisplay(String females, String country, String males, String total) {
        waitForElementVisible(driver,HomePageUI.DYNAMIC_DATA_ROW,females,country,males,total);
       return isElementDisplay(driver,HomePageUI.DYNAMIC_DATA_ROW,females,country,males,total);
    }

    public void deleteRowByCountryName(String countryName) {
        waitForElementClickable(driver,HomePageUI.DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME,countryName);
        clickToElement(driver,HomePageUI.DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME,countryName);
    }

    public void editRowByCountryName(String countryName) {
        waitForElementClickable(driver,HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME,countryName);
        clickToElement(driver,HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME,countryName);
    }

    public void clickToLoadDataButton() {
        waitForElementClickable(driver,HomePageUI.LOAD_DATA_BUTTON);
        clickToElement(driver,HomePageUI.LOAD_DATA_BUTTON);
        sleepInSecond(2);
    }

    public void enterToTextboxByIndex(String rowIndex, String columnName, String valueToSenkey) {
        //Từ colum name làm sao để lấy ra được colum index?
         int columnIndexNumber  =getListElement(driver,HomePageUI.PRECEDING_SIBLING_COLUM_NAME,columnName).size() +1 ;

        //Convert nó sang dạng text(string)
        String columnIndex = String.valueOf(columnIndexNumber);

        //Truyền 2 giá trị Row index và Colum index vào locator để tương tác và valuySenkey
        senkeyToElement(driver,HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX,valueToSenkey,rowIndex,columnIndex);

    }

    public void selectToDropdownByIndex(String rowIndex, String columnName, String valueToSelect) {
        //Từ colum name làm sao để lấy ra được colum index?
        int columnIndexNumber  =getListElement(driver,HomePageUI.PRECEDING_SIBLING_COLUM_NAME,columnName).size() +1 ;

        //Convert nó sang dạng text(string)
        String columnIndex = String.valueOf(columnIndexNumber);

        waitForElementClickable(driver,HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX,rowIndex,columnIndex);
        selectItemDropdown(driver,HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX,valueToSelect,rowIndex,columnIndex);

    }

    public void checkToCheckboxByIndex(String rowIndex, String columnName, boolean checkOrUncheck) {
        //Từ colum name làm sao để lấy ra được colum index?
        int columnIndexNumber  = getListElement(driver,HomePageUI.PRECEDING_SIBLING_COLUM_NAME,columnName).size() +1 ;

        //Convert nó sang dạng text(string)
        String columnIndex = String.valueOf(columnIndexNumber);

        if(checkOrUncheck){
           checkTheCheckboxOrRadio(driver,HomePageUI.DYNAMIC_RADIO_BY_ROW_AND_COLUMN_INDEX,rowIndex,columnIndex);
        }else{
            unCheckTheCheckboxOrRadio(driver,HomePageUI.DYNAMIC_RADIO_BY_ROW_AND_COLUMN_INDEX,rowIndex,columnIndex);
        }
    }

    public void clickToButtonByIndex(String rowIndex, String iconName) {
        waitForElementClickable(driver,HomePageUI.DYNAMIC_INCON_BY_ROW_INDEX,rowIndex,iconName);
        clickToElement(driver,HomePageUI.DYNAMIC_INCON_BY_ROW_INDEX,rowIndex,iconName);
        sleepInSecond(2);
    }

// JQUERY
    public boolean isFileLoadedByName(String... imageName) {
       return isElementDisplay(driver,HomePageUI.DYNAMIC_FILE_LOADED_BY_FILE_NAME,imageName);
    }

    public void clickToSatrt() {
        List<WebElement> allStart = getListElement(driver, HomePageUI.START_BUTTON);
        for(WebElement start:allStart){
            waitForElementClickable(driver,HomePageUI.START_BUTTON);
            clickToElement(driver,HomePageUI.START_BUTTON);
        }

    }

    public boolean isFileUpLoadedByName(String... fileName) {
        return isElementDisplay(driver,HomePageUI.DYNAMIC_FILE_UPLOADED_BY_NAME,fileName);
    }
}
