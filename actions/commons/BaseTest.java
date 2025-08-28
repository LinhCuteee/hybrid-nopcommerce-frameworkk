package commons;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.time.Duration;
import java.util.Random;

public class BaseTest {
    private WebDriver driver;

    public WebDriver getWebDriver() {
        return driver;
    }

    protected Logger log;

    public BaseTest() {
        log = LogManager.getLogger(getClass());
    }



    protected WebDriver getBrowserDriver(String browserName){
        // chuyển từ kiểu String sang kiểu Enum BrowserList
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

        switch (browser){
            case CHROME:
                driver= new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case  EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }

        driver.get(GlobalConstants.DEV_USER_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));

        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName,String url){
        // chuyển từ kiểu String sang kiểu Enum BrowserList
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

        switch (browser){
            case CHROME:
                driver= new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case  EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));

        return driver;
    }


    protected boolean verifyTrue(boolean condition) {
        boolean status = true;
        try {
            Assert.assertTrue(condition);
            log.info("---------------------PASSED----------------------");
        } catch (Throwable e) {
            status = false;
            log.info("---------------------FAILED----------------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean status = true;
        try {
            Assert.assertFalse(condition);
            log.info("---------------------PASSED----------------------");

        } catch (Throwable e) {
            status = false;
            log.info("---------------------FAILED----------------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info("---------------------PASSED----------------------");

        } catch (Throwable e) {
            pass = false;
            log.info("---------------------FAILED----------------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    @BeforeSuite
    public void deleteFileInReport() {
        // Remove all file in ReportNG screenshot (image)
       // deleteAllFileInFolder("reportNGImage");

        // Remove all file in Allure attachment (json file)
        deleteAllFileInFolder("allure-report");
        deleteAllFileInFolder("allure-results");
    }

    public void deleteAllFileInFolder(String folderName) {
        try {
            String pathFolderDownload = GlobalConstants.PROJECT_PATH + File.separator + folderName;
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();

            if (listOfFiles != null && listOfFiles.length > 0) {
                for (File f : listOfFiles) {
                    if (f.isFile() && !f.getName().equals("environment.properties")) {
                        f.delete();
                    }
                }
            } else {
                System.out.println("Không tìm thấy thư mục hoặc thư mục rỗng: " + pathFolderDownload);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected int generateRandomNumber() {
        return new Random().nextInt(9999);
    }

}
