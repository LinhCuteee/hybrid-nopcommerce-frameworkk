package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

public class GeneraterPage {
    public static LoginPO getLoginPage(WebDriver driver){
        return new LoginPO(driver);
    }
}
