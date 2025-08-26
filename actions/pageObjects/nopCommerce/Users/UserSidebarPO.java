package pageObjects.nopCommerce.Users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.GeneratorPage;
import pageUIs.nopCommerce.Users.UserSidebarPageUI;

public class UserSidebarPO extends BasePage {
    private WebDriver driver;

    public UserSidebarPO(WebDriver driver){
        this.driver=driver;
    }

    public UserCustomerInfoPO openCustomerPage() {
        waitForElementClickable(driver, UserSidebarPageUI.CUSTOMER_LINK);
        clickToElement(driver, UserSidebarPageUI.CUSTOMER_LINK);
        return GeneratorPage.getUserCustomerInforPage(driver);
    }

    public UserAdressesPO openAdressesPage() {
        waitForElementClickable(driver, UserSidebarPageUI.ADDRESSES_LINK);
        clickToElement(driver, UserSidebarPageUI.ADDRESSES_LINK);
        return GeneratorPage.getUserAdressesPage(driver);
    }

    public UserOrderPO openOrderPage() {
        waitForElementClickable(driver, UserSidebarPageUI.ORDER_LINK);
        clickToElement(driver,  UserSidebarPageUI.ORDER_LINK);
        return new UserOrderPO(driver);

    }


    public UserRewardPointPO openRewardPoint() {
        waitForElementClickable(driver, UserSidebarPageUI.REWARDPOINTLINK);
        clickToElement(driver, UserSidebarPageUI.REWARDPOINTLINK);
        return new UserRewardPointPO(driver);
    }

    //Dùng cách này khi có <20 Page
    //BasePage bage = new UserCustomorPO(driver);
    public BasePage openSideBarLinkByPageName(String value){
        waitForElementClickable(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME,value);
        clickToElement(driver,UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME,value);
        switch (value){
            case "Customer info":
                return GeneratorPage.getUserCustomerInforPage(driver);
            case "Reward points":
                return GeneratorPage.getUserRewardPointPage(driver);
            case"Orders":
                return GeneratorPage.getUserOrderPage(driver);
            case"Addresses":
                return GeneratorPage.getUserAdressesPage(driver);
            default:
                throw new IllegalArgumentException("Page name is not valid.");
        }
    }


    public void openSideBarLinkByPageNames(String value){
        waitForElementClickable(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME,value);
        clickToElement(driver,UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME,value);}
}
