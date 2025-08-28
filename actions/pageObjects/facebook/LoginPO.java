package pageObjects.facebook;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.facebook.LoginUI;

public class LoginPO extends BasePage {
    private WebDriver driver;

    public LoginPO(WebDriver driver){
        this.driver=driver;
    }

    public void clickToNewAccountButton() {
        waitForElementClickable(driver, LoginUI.CREATE_NEW_ACCOUNT_BUTTON);
        clickToElement(driver,LoginUI.CREATE_NEW_ACCOUNT_BUTTON);
    }

    public void EnterToEmailAddressTextbox(String emailAddress) {
        waitForElementVisible(driver,LoginUI.EMAIL_ADDRESS_TEXTBOX);
        senkeyToElement(driver,LoginUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
    }

    public boolean isComfirmEmailTextboxDispalyed() {
        return  isElementDisplay(driver,LoginUI.COMFIRM_EMAIL_ADDRESS_TEXTBOX);
    }

    public void clickToCloseIcon() {
        waitForElementClickable(driver,LoginUI.CLICK_ICON);
        clickToElement(driver,LoginUI.CLICK_ICON);
    }

    public boolean isComfirmEmailTextboxUndispalyed() {
        return isElementUndisplay(driver,LoginUI.COMFIRM_EMAIL_ADDRESS_TEXTBOX);

    }
}
