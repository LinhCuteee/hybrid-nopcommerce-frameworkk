package pageObjects.nopCommerce.Users;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.GeneratorPage;
import pageUIs.nopCommerce.Users.UserHomePageUI;

public class UserHomePO extends BasePage {
    private WebDriver driver;

    public UserHomePO(WebDriver driver) {

        this.driver = driver;// lấy id của local gán vào id của global
    }
    @Step("Open Register page")
    public UserRegisterPO openRegisterPage() {
        waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
        clickToElement(driver, UserHomePageUI.REGISTER_LINK);
        return GeneratorPage.getUsertRegistorPage(driver);
    }

    @Step("Open Login page")
    public UserLoginPO openLoginPage() {
        waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
        clickToElement(driver, UserHomePageUI.LOGIN_LINK);
        return GeneratorPage.getUserLoginPage(driver);
    }

    @Step("Verify My Account link is display")
    public boolean isMyAccountLinkDislayed() {
        waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplay(driver, UserHomePageUI.MY_ACCOUNT_LINK);
    }

    @Step("Open My Account page")
    public UserCustomerInfoPO openMyAccountPage() {
        waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return GeneratorPage.getUserCustomerInforPage(driver);
    }
}
