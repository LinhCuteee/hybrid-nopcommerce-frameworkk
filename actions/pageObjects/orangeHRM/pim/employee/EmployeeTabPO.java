package pageObjects.orangeHRM.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.PageGenerater;
import pageUIs.orangeHRM.pim.employee.EmployeeTabPageUI;

public class EmployeeTabPO extends BasePage {
    private WebDriver driver;
    public EmployeeTabPO(WebDriver driver){
        this.driver=driver;
    }

    public PersonalDetailPO openPersionalDetailPage(){
        waitForElementClickable(driver, EmployeeTabPageUI.PRESIONAL_DETAILT_LINK);
        clickToElement(driver,EmployeeTabPageUI.PRESIONAL_DETAILT_LINK);
        waitAllIconInVisible(driver);
        return PageGenerater.getPersonalDetailPage(driver);
    }

    public ContactDetailPO openContactDetailPage(){
        waitForElementClickable(driver, EmployeeTabPageUI.CONTACT_DETAILT_LINK);
        clickToElement(driver,EmployeeTabPageUI.CONTACT_DETAILT_LINK);
        waitAllIconInVisible(driver);
        return PageGenerater.getContacDetailPage(driver);
    }


}
