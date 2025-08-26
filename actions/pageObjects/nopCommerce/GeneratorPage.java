package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.Admin.AdminDashboardPO;
import pageObjects.nopCommerce.Admin.AdminLoginPO;
import pageObjects.nopCommerce.Users.*;

public class GeneratorPage {

    public static UserHomePO getUserHomePage(WebDriver driver) {
        return new UserHomePO(driver);
    }

    public static UserCustomerInfoPO getUserCustomerInforPage(WebDriver driver) {
        return new UserCustomerInfoPO(driver);
    }

    public static UserRegisterPO getUsertRegistorPage(WebDriver driver) {
        return new UserRegisterPO(driver);
    }

    public static UserLoginPO getUserLoginPage(WebDriver driver) {
        return new UserLoginPO(driver);
    }

    public static UserOrderPO getUserOrderPage(WebDriver driver) {
        return new UserOrderPO(driver);
    }

    public static UserAdressesPO getUserAdressesPage(WebDriver driver) {
        return new UserAdressesPO(driver);
    }

    public static UserRewardPointPO getUserRewardPointPage(WebDriver driver) {
        return new UserRewardPointPO(driver);
    }

    public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
        return new AdminDashboardPO(driver);
    }

    public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPO(driver);
    }
}






