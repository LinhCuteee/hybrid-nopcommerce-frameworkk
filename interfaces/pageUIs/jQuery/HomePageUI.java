package pageUIs.jQuery;

public class HomePageUI {
    public static final String DYNAMIC_PAGE_LINK ="Xpath=//ul[@class='qgrd-pagination-ul']/li/a[text()='%s']";
    public static final String DYNAMIC_TEXTBOX_BY_HEADER_NAME= "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
    public static final String DYNAMIC_DATA_ROW = "xpath=//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and  text()='%s']/following-sibling::td[@data-key='males' and  text()='%s']/following-sibling::td[@data-key='total' and  text()='%s']";
    public static final String DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME="xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-remove-row-btn']";
    public static final String DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME="xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-edit-row-btn']";
    public static final String LOAD_DATA_BUTTON = "css=button#load";
    public static final String PRECEDING_SIBLING_COLUM_NAME = "xpath=//th[text()='%s']/preceding-sibling::th";
    public static final String DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]/input";
    public static final String DYNAMIC_RADIO_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]//input";
    public static final String DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]//select";
    public static final String DYNAMIC_INCON_BY_ROW_INDEX ="Xpath=//tr[%s]//button[starts-with(@title,'%s')]";


    public static final String DYNAMIC_FILE_LOADED_BY_FILE_NAME = "xpath=//p[@class='name' and text()='%s']";
    public static final String START_BUTTON="xpath=//td//button[@class='btn btn-primary start']";
    public static final String DYNAMIC_FILE_UPLOADED_BY_NAME="xpath=//p[@class='name']/a[text()='%s']";
}
