package pageObjects.nopCommerce.Users;

import org.openqa.selenium.WebDriver;

public class UserAdressesPO extends UserSidebarPO {
    private WebDriver driver;
    public UserAdressesPO(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

}
