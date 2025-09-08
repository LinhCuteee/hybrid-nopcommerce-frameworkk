package pageObjects.orangeHRM.pim;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.pim.employee.EmployeeListPO;
import pageUIs.orangeHRM.DashboardPageUI;

public class DashboardPO extends BasePage {
    private WebDriver driver;
    public DashboardPO(WebDriver driver){
        this.driver=driver;
    }

    public EmployeeListPO clickToPIMPage() {
        waitForElementClickable(driver, DashboardPageUI.PIM_Link);
        clickToElement(driver,DashboardPageUI.PIM_Link);
        waitAllIconInVisible(driver);
        return new EmployeeListPO(driver);
    }
}
