package pageObjects.nopCommerce.Admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.Admin.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {
    WebDriver driver;
    public AdminLoginPO(WebDriver driver){
        this.driver=driver;
    }

    public void entorToEmailTextbox(String email) {
        waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
        senkeyToElement(driver,AdminLoginPageUI.EMAIL_TEXTBOX,email);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        senkeyToElement(driver,AdminLoginPageUI.PASSWORD_TEXTBOX,password);
    }

    public AdminDashboardPO  clickToLoginButton() {
        waitForElementClickable(driver,AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,AdminLoginPageUI.LOGIN_BUTTON);
        return new AdminDashboardPO(driver);
    }
}
