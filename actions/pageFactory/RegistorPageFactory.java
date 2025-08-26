package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistorPageFactory extends BasePage{
    private WebDriver driver;

    public RegistorPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='gender-male']")
    @CacheLookup
    private WebElement genderMaleRadio;

    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement firstNameTextbox;

    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement lastNameTextbox;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailTextbox;

    @FindBy(xpath = "//input[@id='Company']")
    private WebElement companyTextbox;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordTextbox;

    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    private WebElement ConfirmPasswordTextbox;

    @FindBy(xpath = "//button[@id='register-button']")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@class='result']")
    private WebElement registerSuccessMessage;

    @FindBy(xpath = "//a[@class='ico-logout']")
    private WebElement logoutLink;


    public void clickToMaleRadio() {
        waitForElementClickable(driver,genderMaleRadio);
        clickToElement(genderMaleRadio);
    }

    public void enterToFirstNameTextbox(String firtName) {
        waitForElementVisible(driver,firstNameTextbox);
        senkeyToElement(firstNameTextbox,firtName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver,lastNameTextbox);
        senkeyToElement(lastNameTextbox,lastName);
    }

    public void enterToEmailTextbox(String emailAdress) {
        waitForElementVisible(driver,emailTextbox);
        senkeyToElement(emailTextbox,emailAdress);
    }

    public void enterToCompanyNameTextbox(String companyName) {
        waitForElementVisible(driver,companyTextbox);
        senkeyToElement(companyTextbox,companyName);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver,passwordTextbox);
        senkeyToElement(passwordTextbox,password);
    }

    public void enterToCofirmPasswordTextbox(String password) {
        waitForElementVisible(driver,ConfirmPasswordTextbox);
        senkeyToElement(ConfirmPasswordTextbox,password);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver,registerButton);
        clickToElement(registerButton);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver,registerSuccessMessage);
        return getTextElement(registerSuccessMessage);
    }

    public void clickToLogOutLink() {
        waitForElementClickable(driver,logoutLink);
        clickToElement(logoutLink);
    }
}
