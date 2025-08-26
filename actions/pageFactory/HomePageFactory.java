package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory extends BasePage{
    private WebDriver driver;

    public HomePageFactory(WebDriver driver){
        this.driver = driver;

        //this la kieu dl object = HomePageFactory.class
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath ="//a[@class='ico-register']" )
    private WebElement registerLink;

    @FindBy(xpath = "//a[@class='ico-login']")
    private WebElement loginLink;

    @FindBy(xpath = "//a[@class='ico-account']")
    private WebElement myAccountLink;
    public void clickToRegisterLink() {
        waitForElementClickable(driver,registerLink);
        clickToElement(registerLink);
    }

    public void clickToLoginLink() {
        waitForElementClickable(driver,loginLink);
        clickToElement(loginLink);
    }

    public boolean isMyAccountLinkDislayed() {
        waitForElementVisible(driver,myAccountLink);
        return isElementDisplay(myAccountLink);
    }

    public void clickToMyAccountLink() {
        waitForElementClickable(driver,myAccountLink);
        clickToElement(myAccountLink);
    }
}
