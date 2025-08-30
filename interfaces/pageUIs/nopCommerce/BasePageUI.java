package pageUIs.nopCommerce;

public class BasePageUI {
    public static final String CUSTOMER_LINK = "/xpath=/div[@class='block block-account-navigation']//a[text()='Customer info']";
    public static final String REWARDPOINTLINK = "xpath=//div[@class='block block-account-navigation']//a[text()='Reward points']";
    public static final String ORDER_LINK = "xpath=//div[@class='block block-account-navigation']//a[text()='Orders']";
    public static final String ADDRESSES_LINK = "xpath=//div[@class='block block-account-navigation']//a[text()='Addresses']";
    public static final String FILE_BUTTON = "CSS=input[type='file']";


    public static final String LINK_TEXT_BY_TEXT="xpath=//a[text()='%s']";
    public static final String RADIO_BY_ID="xpath=//input[@id='%s']";
    public static final String TEXTBOX_BY_ID="xpath=//input[@id='%s']";
    public static final String BUTTON_BY_TEXT="xpath=//button[text()='%s']";

}
