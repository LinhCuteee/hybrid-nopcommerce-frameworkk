package pageObjects.orangeHRM.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.BasePageUI;
import pageUIs.orangeHRM.pim.employee.EmployeeListPageUI;

public class EmployeeListPO extends BasePage {
    private WebDriver driver;
    public EmployeeListPO(WebDriver driver){
        this.driver=driver;
    }

    public AddNewEmployeePO clickToAddEmployeeButton() {
        waitForElementClickable(driver, EmployeeListPageUI.NEW_EMPLOYEE_NAV_BUTTON);
        clickToElement(driver,EmployeeListPageUI.NEW_EMPLOYEE_NAV_BUTTON);
        waitAllIconInVisible(driver);
        return new AddNewEmployeePO(driver);
    }
}
