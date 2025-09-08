package pageObjects.orangeHRM.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.GeneratorPage;
import pageObjects.orangeHRM.PageGenerater;
import pageUIs.orangeHRM.pim.employee.AddNewEmployeePageUI;

public class AddNewEmployeePO extends BasePage {
    private WebDriver driver;
    public AddNewEmployeePO(WebDriver driver){
        this.driver=driver;
    }

    public void enterToFirtNameTextbox(String valueFirstName) {
        waitForElementVisible(driver, AddNewEmployeePageUI.FIRST_NAME_TEXTBOX);
        senkeyToElement(driver,AddNewEmployeePageUI.FIRST_NAME_TEXTBOX,valueFirstName);
    }

    public void enterToLastNameTextbox(String valueLastName) {
        waitForElementVisible(driver, AddNewEmployeePageUI.LAST_NAME_TEXTBOX);
        senkeyToElement(driver,AddNewEmployeePageUI.LAST_NAME_TEXTBOX,valueLastName);
    }

    public String getEmploueeId(String attributeName) {
        waitForElementVisible(driver, AddNewEmployeePageUI.EMPLOYEE_ID_TEXTBOX);
        return getAttributeValue(driver, AddNewEmployeePageUI.EMPLOYEE_ID_TEXTBOX,attributeName );
    }

    public PersonalDetailPO clickToSaveButtonAtAddEmployee() {
        waitForElementClickable(driver,AddNewEmployeePageUI.SAVE_BUTTON_AT_ADD_EMPLOYEE);
        clickToElement(driver,AddNewEmployeePageUI.SAVE_BUTTON_AT_ADD_EMPLOYEE);
        return PageGenerater.getPersonalDetailPage(driver);
    }

}
