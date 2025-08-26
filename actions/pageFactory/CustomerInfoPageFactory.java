package pageFactory;

import org.bouncycastle.jcajce.provider.drbg.DRBG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInfoPageFactory extends BasePage{
    private WebDriver driver;

    public CustomerInfoPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='gender-male']")
    private WebElement genderMaleRadio;

    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement firstNameTextbox;

    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement lastNameTextbox;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailTextbox;

    @FindBy(xpath = "//input[@id='Company']")
    private WebElement companyTextbox;


    public boolean isGenderMaleSelected() {
        waitForElementSelected(driver,genderMaleRadio);
        return iselementSelected(genderMaleRadio);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver,firstNameTextbox);
        return getAttributeValue(firstNameTextbox,"value");
    }

    public String getLastNameTextboxvalue() {
        waitForElementVisible(driver,lastNameTextbox);
        return getAttributeValue(lastNameTextbox,"value");
    }

    public String getEmailTextboxValue() {
        waitForElementVisible(driver,emailTextbox);
        return getAttributeValue(emailTextbox,"value");
    }

    public String getCompanyTextboxValue() {
        waitForElementVisible(driver,companyTextbox);
        return getAttributeValue(companyTextbox,"value");
    }
}
