package pageUIs.orangeHRM.pim.employee;

public class PersonalDetailPageUI {
    public static final String AVATAR_IMG = "css=.orangehrm-edit-employee-image>.employee-image";
    public static final String SAVE_BUTTON_AT_CHANGE_PICTURE = "xpath=//h6[text()='Change Profile Picture']/parent::div//button[contains(string(),'Save')]";
    public static final String FIRST_NAME_TEXTBOX="name=firstName";
    public static final String LAST_NAME_TEXTBOX="name=lastName";
    public static final String EMPLOYEE_ID_TEXTBOX="xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
    public static final String DRIVER_LICENSE_TEXTBOX="xpath=//label[text()=\"Driver's License Number\"]/parent::div/following-sibling::div/input";
    public static final String LICENSE_EXPIRY_TEXTBOX="xpath=//label[text()='License Expiry Date']/parent::div/following-sibling::div//input";
    public static final String NATIONALITY_DROPDOWN="xpath=//label[text()='Nationality']/parent::div/following-sibling::div//i";
    public static final String NATIONALITY_DROPDOWN_CHILD="xpath=//label[text()='Nationality']/parent::div//following-sibling::div//div[contains(@class,'oxd-select-option')]/span";
    public static final String NATIONALITY_DROPDOWN_SELECTED="xpath=//label[text()='Nationality']/parent::div//following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String MARITAL_STATUS_DROPDOWN="xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//i";
    public static final String MARITAL_STATUS_DROPDOWN_CHILD="xpath=//label[text()='Marital Status']/parent::div//following-sibling::div//div[@class='oxd-select-option']/span";
    public static final String MARITAL_STATUS_DROPDOWN_SELECTED="xpath=//label[text()='Marital Status']/parent::div//following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String DATE_OF_BIRTH_DROPDOWN="xpath=//label[text()='Date of Birth']/parent::div/following-sibling::div//input";
    public static final String GENDER_RADIO ="xpath=//label[text()='Gender']/parent::div//following-sibling::div//label[contains(string(),'%s')]/input";
    public static final String SAVE_BUTTON_AT_PERSIONAL_DETAIL="xpath=//h6[text()='Personal Details']/parent::div//button[contains(string(),'Save')]";

}
