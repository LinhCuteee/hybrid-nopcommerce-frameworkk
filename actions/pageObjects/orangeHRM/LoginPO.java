package pageObjects.orangeHRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.pim.DashboardPO;
import pageUIs.nopCommerce.BasePageUI;
import pageUIs.orangeHRM.LoginPageUI;

public class LoginPO extends BasePage {
    private WebDriver driver;
    public LoginPO(WebDriver driver){
        this.driver=driver;
    }

    public void enterToUserNameTextbox(String usernameValue) {
        waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
        senkeyToElement(driver,LoginPageUI.USERNAME_TEXTBOX,usernameValue);
    }

    public void enterToPasswordTextbox(String passwordValue) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        senkeyToElement(driver,LoginPageUI.PASSWORD_TEXTBOX,passwordValue);
    }

    public DashboardPO clikToLoginButton() {
        waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
        waitForListElementInvisible(driver, BasePageUI.LOADING_ICON);
        return new DashboardPO(driver);
    }
}
