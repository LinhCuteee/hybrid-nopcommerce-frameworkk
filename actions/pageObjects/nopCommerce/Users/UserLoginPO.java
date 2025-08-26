package pageObjects.nopCommerce.Users;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.GeneratorPage;
import pageUIs.nopCommerce.Users.UserLoginPageUI;

public class UserLoginPO extends BasePage {
    private WebDriver driver;

    public UserLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter to Email textbox with value: {0}")
    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
        senkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX,emailAddress);
    }

    @Step("Enter to Password textbox with value: {0}")
    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
        senkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX,password);
    }

    @Step("Click to Login button")
    public void clickToLoginButton() {
        waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
    }

    @Step("Open Home page")
    public UserHomePO openHomePage(String emailAddress, String password){
        enterToEmailTextbox(emailAddress);
        enterToPasswordTextbox(password);
        clickToLoginButton();
       return GeneratorPage.getUserHomePage(driver);
    }
}
