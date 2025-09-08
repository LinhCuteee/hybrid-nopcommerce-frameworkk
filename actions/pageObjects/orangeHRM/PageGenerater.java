package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.pim.DashboardPO;
import pageObjects.orangeHRM.pim.employee.AddNewEmployeePO;
import pageObjects.orangeHRM.pim.employee.ContactDetailPO;
import pageObjects.orangeHRM.pim.employee.EmployeeListPO;
import pageObjects.orangeHRM.pim.employee.PersonalDetailPO;

public class PageGenerater {
    public static AddNewEmployeePO getAddNewEmployeePage(WebDriver driver){
        return  new AddNewEmployeePO(driver);
    }
    public static ContactDetailPO getContacDetailPage(WebDriver driver){
        return  new ContactDetailPO(driver);
    }
    public static EmployeeListPO getEmployeeListPage(WebDriver driver){
        return  new EmployeeListPO(driver);
    }
    public static PersonalDetailPO getPersonalDetailPage(WebDriver driver){
        return  new PersonalDetailPO(driver);
    }
    public static LoginPO getLoginPage(WebDriver driver) {
        return new LoginPO(driver);
    }

    public static DashboardPO getDashboardPage(WebDriver driver){
        return  new DashboardPO(driver);
    }

}
