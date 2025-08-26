package pageObjects.nopCommerce.Users;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.Users.UserCustomerInfoPageUI;

public class UserCustomerInfoPO extends UserSidebarPO {

    private WebDriver driver;

   public UserCustomerInfoPO(WebDriver driver) {
       super(driver);
       this.driver = driver;
    }

    @Step("Verify Gender Male is selected")
    public boolean isGenderMaleSelected() {
        waitForElementSelected(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
        return iselementSelected(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
    }

    @Step("Get First Name textbox value")
    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX);
        return getAttributeValue(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX,"value");
    }

    @Step("Get Last Name textbox value")
    public String getLastNameTextboxvalue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX);
        return getAttributeValue(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX,"value");

    }

    @Step("Get Email textbox value")
    public String getEmailTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
        return getAttributeValue(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX,"value");

    }

    @Step("Get Company Name textbox value")
    public String getCompanyTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
        return getAttributeValue(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX,"value");

    }


}
