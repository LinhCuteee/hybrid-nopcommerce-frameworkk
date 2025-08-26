package pageObjects.nopCommerce.Users;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.GeneratorPage;
import pageUIs.nopCommerce.Users.UserRegistorPageUI;

public class UserRegisterPO extends BasePage {
    private WebDriver driver;

    public UserRegisterPO(WebDriver driver){
        this.driver = driver;
    }

    @Step("Click to Male radio")
    public void clickToMaleRadio() {
        waitForElementClickable(driver, UserRegistorPageUI.GENDER_MALE_RADIO);
        checkTheCheckboxOrRadio(driver, UserRegistorPageUI.GENDER_MALE_RADIO);
    }

    @Step("Enter to First Name textbox with value:{0}")
    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, UserRegistorPageUI.FIRST_NAME_TEXTBOX);
        senkeyToElement(driver, UserRegistorPageUI.FIRST_NAME_TEXTBOX,firstName);
    }

    @Step("Enter to Last Name textbox with value:{0}")
    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, UserRegistorPageUI.LAST_NAME_TEXTBOX);
        senkeyToElement(driver, UserRegistorPageUI.LAST_NAME_TEXTBOX,lastName);
    }

    @Step("Enter to Eamil textbox with value:{0}")
    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, UserRegistorPageUI.EMAIL_TEXTBOX);
        senkeyToElement(driver, UserRegistorPageUI.EMAIL_TEXTBOX,emailAddress);
    }

    @Step("Enter to Compant Name textbox with value:{0}")
    public void enterToCompanyNameTextbox(String company) {
        waitForElementVisible(driver, UserRegistorPageUI.COMPANY_TEXTBOX);
        senkeyToElement(driver, UserRegistorPageUI.COMPANY_TEXTBOX,company);
    }

    @Step("Enter to Password textbox with value:{0}")
    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, UserRegistorPageUI.PASSWORD_TEXTBOX);
        senkeyToElement(driver, UserRegistorPageUI.PASSWORD_TEXTBOX,password);
    }

    @Step("Enter to Comfirm Password textbox with value:{0}")
    public void enterToCofirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver, UserRegistorPageUI.CONFIRM_PASSWORD_TEXTBOX);
        senkeyToElement(driver, UserRegistorPageUI.CONFIRM_PASSWORD_TEXTBOX,confirmPassword);
    }

    @Step("Click to Register button")
    public void clickToRegisterButton() {
        waitForElementClickable(driver, UserRegistorPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegistorPageUI.REGISTER_BUTTON);
    }

    @Step("Get Register Success Massage")
    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, UserRegistorPageUI.REGISTOR_SUCCESS_MESSAGE);
        return getTextElement(driver, UserRegistorPageUI.REGISTOR_SUCCESS_MESSAGE);
    }

    @Step("Open Home page")
    public UserHomePO openHomePage() {
        waitForElementClickable(driver, UserRegistorPageUI.LOG_OUT_LINK);
        clickToElement(driver, UserRegistorPageUI.LOG_OUT_LINK);
        return GeneratorPage.getUserHomePage(driver);
    }


    @Step("Get Register Page Title")
    public String getRegistorPageTitle() {
        waitForElementVisible(driver,UserRegistorPageUI.PAGE_TITLE);
        return getTextElement(driver,UserRegistorPageUI.PAGE_TITLE);
    }
}
