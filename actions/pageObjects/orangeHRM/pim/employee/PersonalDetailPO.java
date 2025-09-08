package pageObjects.orangeHRM.pim.employee;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.orangeHRM.pim.employee.PersonalDetailPageUI;

import java.util.List;

public class PersonalDetailPO extends EmployeeTabPO {
    private WebDriver driver;

    public PersonalDetailPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToEmployeeAvatarImage() {
        waitForElementVisible(driver, PersonalDetailPageUI.AVATAR_IMG);
        clickToElement(driver, PersonalDetailPageUI.AVATAR_IMG);
    }

    public Dimension getAvatarSize() {
        waitForElementVisible(driver, PersonalDetailPageUI.AVATAR_IMG);
        return getElementSize(driver, PersonalDetailPageUI.AVATAR_IMG);
    }

    public void clickToSaveAtChangeProfilePictrue() {
        waitForElementVisible(driver, PersonalDetailPageUI.SAVE_BUTTON_AT_CHANGE_PICTURE);
        clickToElement(driver, PersonalDetailPageUI.SAVE_BUTTON_AT_CHANGE_PICTURE);
    }


    public boolean isProfileAvatarUploadSuccessed(Dimension beforeAvatarSize) {
        Dimension afterAvatarSize = getElementSize(driver, PersonalDetailPageUI.AVATAR_IMG);
        return !beforeAvatarSize.equals(afterAvatarSize);
    }

    public void enterToFirstNameTextbox(String valueFirstname) {
        waitForElementVisible(driver, PersonalDetailPageUI.FIRST_NAME_TEXTBOX);
        senkeyToElement(driver, PersonalDetailPageUI.FIRST_NAME_TEXTBOX, valueFirstname);
    }

    public void enterToLastNameTextbox(String valueLastName) {
        waitForElementVisible(driver, PersonalDetailPageUI.LAST_NAME_TEXTBOX);
        senkeyToElement(driver, PersonalDetailPageUI.LAST_NAME_TEXTBOX, valueLastName);
    }

    public String getEmployeeID(String attributeName) {
        waitForElementVisible(driver, PersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX);
        return getAttributeValue(driver, PersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX, attributeName);
    }

    public void enterToDriverLicenerTextbox(String valueDriverLicener) {
        waitForElementVisible(driver, PersonalDetailPageUI.DRIVER_LICENSE_TEXTBOX);
        senkeyToElement(driver, PersonalDetailPageUI.DRIVER_LICENSE_TEXTBOX, valueDriverLicener);
    }

    public void enterToLicenseExpiryTextbox(String valueLicenseExpiry) {
        waitForElementVisible(driver, PersonalDetailPageUI.LICENSE_EXPIRY_TEXTBOX);
        senkeyToElement(driver, PersonalDetailPageUI.LICENSE_EXPIRY_TEXTBOX, valueLicenseExpiry);
    }

    public void selectToNationalityDropdown(String valueNationality) {
        waitForElementClickable(driver, PersonalDetailPageUI.NATIONALITY_DROPDOWN);
        selectItemInCustomDropdown(driver, PersonalDetailPageUI.NATIONALITY_DROPDOWN, PersonalDetailPageUI.NATIONALITY_DROPDOWN_CHILD, valueNationality);
    }

    public void selectToMaritalStatusDropdown(String marialStatus) {
        waitForElementClickable(driver, PersonalDetailPageUI.MARITAL_STATUS_DROPDOWN);
        selectItemInCustomDropdown(driver, PersonalDetailPageUI.MARITAL_STATUS_DROPDOWN, PersonalDetailPageUI.MARITAL_STATUS_DROPDOWN_CHILD, marialStatus);
    }

    public void enterToDateOfBirthTextbox(String dateOfBirth) {
        waitForElementVisible(driver, PersonalDetailPageUI.DATE_OF_BIRTH_DROPDOWN);
        senkeyToElement(driver, PersonalDetailPageUI.DATE_OF_BIRTH_DROPDOWN,dateOfBirth);
    }

    public void selectGenderRadioButton(String restParametor) {
        clickToElementByJS(driver,PersonalDetailPageUI.GENDER_RADIO,restParametor);
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, PersonalDetailPageUI.SAVE_BUTTON_AT_PERSIONAL_DETAIL);
        clickToElement(driver, PersonalDetailPageUI.SAVE_BUTTON_AT_PERSIONAL_DETAIL);
    }

    public String getFirstNameTextboxValue(String attributeName) {
        waitForElementVisible(driver,PersonalDetailPageUI.FIRST_NAME_TEXTBOX);
       return getAttributeValue(driver,PersonalDetailPageUI.FIRST_NAME_TEXTBOX,attributeName);
    }

    public String getLastNameTextboxValue(String attributeName) {
        waitForElementVisible(driver,PersonalDetailPageUI.LAST_NAME_TEXTBOX);
        return getAttributeValue(driver,PersonalDetailPageUI.LAST_NAME_TEXTBOX,attributeName);
    }

    public String getDriverLicenerTextboxValue(String attributeName) {
        waitForElementVisible(driver,PersonalDetailPageUI.DRIVER_LICENSE_TEXTBOX);
        return getAttributeValue(driver,PersonalDetailPageUI.DRIVER_LICENSE_TEXTBOX,attributeName);
    }

    public String getLicenerExpityTextboxValue(String attributeName) {
        waitForElementVisible(driver,PersonalDetailPageUI.LICENSE_EXPIRY_TEXTBOX);
        return getAttributeValue(driver,PersonalDetailPageUI.LICENSE_EXPIRY_TEXTBOX,attributeName);

    }

    public String getNationalityDropdownValue() {
        waitForElementVisible(driver,PersonalDetailPageUI.NATIONALITY_DROPDOWN_SELECTED);
       return getTextElement(driver,PersonalDetailPageUI.NATIONALITY_DROPDOWN_SELECTED);
    }

    public String getMaritalStatusDropdownValue() {
        waitForElementVisible(driver,PersonalDetailPageUI.MARITAL_STATUS_DROPDOWN_SELECTED);
        return getTextElement(driver,PersonalDetailPageUI.MARITAL_STATUS_DROPDOWN_SELECTED);
    }

    public String getDateOfBirthTextboxValue(String attributeName) {
        waitForElementVisible(driver,PersonalDetailPageUI.DATE_OF_BIRTH_DROPDOWN);
        return getAttributeValue(driver,PersonalDetailPageUI.DATE_OF_BIRTH_DROPDOWN,attributeName);
    }

    public boolean isGenderRadioButtonSelected(String restParametor) {
        waitForElementSelected(driver,PersonalDetailPageUI.GENDER_RADIO,restParametor);
       return iSelementSelected(driver,PersonalDetailPageUI.GENDER_RADIO,restParametor);
    }
}
