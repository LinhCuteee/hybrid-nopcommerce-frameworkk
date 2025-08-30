package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.nopCommerce.GeneratorPage;
import pageObjects.nopCommerce.Users.UserAdressesPO;
import pageObjects.nopCommerce.Users.UserCustomerInfoPO;
import pageObjects.nopCommerce.Users.UserOrderPO;
import pageObjects.nopCommerce.Users.UserRewardPointPO;
import pageUIs.facebook.LoginUI;
import pageUIs.nopCommerce.BasePageUI;
import pageUIs.nopCommerce.Users.UserHomePageUI;

import java.time.Duration;
import java.util.List;
import java.util.Set;


//common function( hàm dùng chung) cho nhiều class khác
public class BasePage {

    // tuân theo nguyên tắc của tính đóng gói (Encapsulation)
    // hàm static có thể truy cập trực tiếp từ phạm vi class
    public static BasePage getBasePage() {
        return new BasePage();
    }

    public void openPageUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPagetUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSourceCode(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backtoPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    // method này trả về alert vì thế k cần switch vào alert nữa
    public Alert waitAlertPrecennt(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.alertIsPresent());
    }

    public void eccpetToAlert(WebDriver driver) {
        waitAlertPrecennt(driver).accept();
    }

    public void cancelToAlert(WebDriver driver) {
        waitAlertPrecennt(driver).dismiss();
    }

    public String getAlertText(WebDriver driver) {
        return waitAlertPrecennt(driver).getText();
    }

    public void senkeyToAlert(WebDriver driver, String keysToSend) {
        waitAlertPrecennt(driver).sendKeys(keysToSend);
    }

    public void switchToWindownByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            driver.switchTo().window(runWindow);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    protected void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);

    }

    protected WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }


    private String castParametor(String locator, String... restParametor) {
        return String.format(locator, (Object[]) restParametor);
    }

/*  - Không nên dùng if-else vì
    - Có thể 2 điều kiện if đều giống nhau
   - Chưa xử lý việc khoảng cách/ tab trong locator
    private By getByLocator(String prifixLocator){
        By by=null;
        if(prifixLocator.toUpperCase().startsWith("ID")){
            by= By.id(prifixLocator.substring(3));
        } else if (prifixLocator.toUpperCase().startsWith("CLASS")) {
            by= By.className(prifixLocator.substring(6));
        } else if (prifixLocator.toUpperCase().startsWith("NAME")) {
            by=By.name(prifixLocator.substring(5));
        } else if (prifixLocator.toUpperCase().startsWith("TAGNAME")) {
            by=By.tagName(prifixLocator.substring(8));
        } else if (prifixLocator.toUpperCase().startsWith("CSS")) {
            by= By.cssSelector(prifixLocator.substring(4));
        } else if (prifixLocator.toUpperCase().startsWith("XPATH")) {
            by=By.xpath(prifixLocator.substring(6));
        }else{
            throw new RuntimeException("Locator Type is not support.");
        }
        return by;
    }*/

    //apply cho findElenment, findElements,explicitWait
    private By getByLocator(String prifixLocator) {
        if (prifixLocator == null | prifixLocator.trim().isEmpty()) {
            throw new IllegalArgumentException("Locator type cannot be null or empty.");
        }
        // cat dau = dau tien thanh mang gom 2 ptu
        String[] locatorARR = prifixLocator.split("=", 2);

        String prefix = locatorARR[0].trim().toUpperCase();
        String locatorvalue = locatorARR[1].trim();

        By by = null;

        switch (prefix) {
            case "ID":
                by = By.id(locatorvalue);
                break;
            case "ClASS":
                by = By.className(locatorvalue);
                break;
            case "NAME":
                by = By.name(locatorvalue);
                break;
            case "TAGNAME":
                by = By.tagName(locatorvalue);
                break;
            case "CSS":
                by = By.cssSelector(locatorvalue);
                break;
            case "XPATH":
                by = By.xpath(locatorvalue);
                break;
            default:
                throw new IllegalArgumentException("Locator type is not supported: " + prifixLocator);
        }
        return by;
    }

    public By getByXpath(String locator) {
        return By.xpath(locator);
    }


    public List<WebElement> getListElement(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }

    public List<WebElement> getListElement(WebDriver driver, String locator, String... restParametor) {
        return driver.findElements(getByLocator(castParametor(locator, restParametor)));
    }

    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    public void clickToElement(WebDriver driver, String locator, String... restParametor) {
        getElement(driver, castParametor(locator, restParametor)).click();
    }

    public void senkeyToElement(WebDriver driver, String locator, String keyToSend) {
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(keyToSend);
    }

    public void senkeyToElement(WebDriver driver, String locator, String keyToSend, String... restParametor) {
        getElement(driver, castParametor(locator, restParametor)).clear();
        getElement(driver, castParametor(locator, restParametor)).sendKeys(keyToSend);

    }

    public void selectItemDropdown(WebDriver driver, String locator, String textItem) {
        new Select(getElement(driver, locator))
                .selectByVisibleText(textItem);

    }

    public void selectItemDropdown(WebDriver driver, String locator, String textItem, String... restParametor) {
        new Select(getElement(driver, castParametor(locator, restParametor)))
                .selectByVisibleText(textItem);

    }

    public String getSelectedItemDropdown(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator))
                .getFirstSelectedOption().getText();
    }

    public Boolean isDropdownMutiple(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String expectedItem) {
        getElement(driver, parentLocator).click();
        sleepInSecond(2);

        WebDriverWait explicit = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));

        List<WebElement> allItems = explicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(childLocator)));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                item.click();
                break;
            }
        }

    }

    public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
        return getElement(driver, locator).getAttribute(attributeName);
    }

    public String getAttributeValue(WebDriver driver, String locator, String attributeName, String... restParametor) {
        return getElement(driver, castParametor(locator, restParametor)).getAttribute(attributeName);
    }

    public String getTextElement(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }

    public String getTextElement(WebDriver driver, String locator, String... restParametor) {
        return getElement(driver, castParametor(locator, restParametor)).getText();
    }

    public String getCssValue(WebDriver driver, String locator, String propertyName) {
        return getElement(driver, locator).getCssValue(propertyName);
    }

    public String getHexaColorFromGRBA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    public int getListElementNumber(WebDriver driver, String locator) {
        return getListElement(driver, locator).size();
    }

    public void checkTheCheckboxOrRadio(WebDriver driver, String locator) {
        if (!getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }

    public void checkTheCheckboxOrRadio(WebDriver driver, String locator, String... restParametor) {
        if (!getElement(driver, castParametor(locator, restParametor)).isSelected()) {
            getElement(driver, castParametor(locator, restParametor)).click();
        }
    }

    public void unCheckTheCheckboxOrRadio(WebDriver driver, String locator) {
        if (getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }

    public void unCheckTheCheckboxOrRadio(WebDriver driver, String locator, String... restParametor) {
        if (getElement(driver, castParametor(locator, restParametor)).isSelected()) {
            getElement(driver, castParametor(locator, restParametor)).click();
        }
    }

    public void overrideGlobalTimeout(WebDriver driver, long time) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }


    public Boolean isElementDisplay(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
        /*try {
            return isElementDisplay(driver, LoginUI.COMFIRM_EMAIL_ADDRESS_TEXTBOX);
        } catch (NoSuchElementException e) {
            return false;
        }*/
    }

    public Boolean isElementUndisplay(WebDriver driver, String locator) {
        overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
        List<WebElement> elements = getListElement(driver, LoginUI.COMFIRM_EMAIL_ADDRESS_TEXTBOX);
        overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);

        if (elements.size() > 0) {
            return false;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            return true;
        } else {
            return true;
        }
    }


    public Boolean isElementDisplay(WebDriver driver, String locator, String... restParametor) {
        return getElement(driver, castParametor(locator, restParametor)).isDisplayed();
    }


    public Boolean iSelementSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    public Boolean iSelementSelected(WebDriver driver, String locator, String... restParametor) {
        return getElement(driver, castParametor(locator, restParametor)).isSelected();
    }

    public Boolean isElementEnable(WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }

    public void switchToIframe(WebDriver driver, String locator) {
        driver.switchTo().frame(getElement(driver, locator));
    }

    public WebDriver switchToDefaultPage(WebDriver driver) {
        return driver.switchTo().defaultContent();
    }

    public void clickAndHold(WebDriver driver, String locator) {
        new Actions(driver).clickAndHold(getElement(driver, locator)).perform();
    }

    public void releaseLeftMouse(WebDriver driver) {
        new Actions(driver).release().perform();
    }

    public void clickToElemnetByAction(WebDriver driver, String locator) {
        new Actions(driver).click(getElement(driver, locator)).perform();
    }

    public void doubleClickToElemnt(WebDriver driver, String locator) {
        new Actions(driver).doubleClick(getElement(driver, locator)).perform();
    }

    public void hoverMoveToEement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getElement(driver, locator)).perform();
    }

    public void rightClickToElemnet(WebDriver driver, String locator) {
        new Actions(driver).contextClick(getElement(driver, locator)).perform();
    }

    public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
        new Actions(driver).dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
    }

    public void scrollToElement(WebDriver driver, String locator) {
        new Actions(driver).scrollToElement(getElement(driver, locator)).perform();
    }

    // element thực hiện nhấn 1 phím trên broad
    public void sendKeybroadToElement(WebDriver driver, String locator, Keys key) {
        new Actions(driver).sendKeys(getElement(driver, locator), key).perform();
    }

    public void sendKeybroadToElement(WebDriver driver, String locator, Keys key, String... restParametor) {
        new Actions(driver).sendKeys(getElement(driver, castParametor(locator, restParametor)), key).perform();
    }

    public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
        String fullFileName = "";
        for (String file : fileNames) {
            fullFileName += GlobalConstants.UPLOAD_PATH + file + "\n";
        }
        // cắt bỏ khoảng trắng ở cuối chuỗi vì Edge chạy k đc nếu có khoảng trắng đầu or cuối chuỗi
        fullFileName = fullFileName.trim();

        // không dùng method senkeyToElemnet vì có clear()
        getElement(driver, BasePageUI.FILE_BUTTON).sendKeys(fullFileName);
    }

/*

    public void senkeyMultipleFile(WebDriver driver, String locator, String fileName1, String fileName2) {
        getElement(driver, locator).sendKeys(System.getProperty("user.dir") + File.separator + "uploadFiles" + File.separator + fileName1
                + "\n" + System.getProperty("user.dir") + File.separator + "uploadFiles" + File.separator + fileName2);
    }*/

    public void hightlightElement(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click;", getElement(driver, locator));
        sleepInSecond(2);
    }

    //scroll cuoi page
    public void scrollToBottomPageByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
    }

    public String getAttributeInDOMByJS(WebDriver driver, String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
                        "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getElement(driver, locator));
    }

    public void scrollToElementOnTopByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void scrollToElementOnDownByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
    }

    public void waitForElementVisible(WebDriver driver, String locator) {
         new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }
    public void waitForElementAttribute(WebDriver driver, String locator, String attribute, String value){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.attributeToBe(getByLocator(locator),attribute,value))  ;
    }

    public void waitForElementAttribute(WebDriver driver, String locator, String attributeName, String attributeValue, String... restParameter){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.attributeToBe(getByLocator(castParametor(locator,restParameter)),attributeName,attributeValue))  ;
    }

    public void waitForElementVisible(WebDriver driver, String locator, String... restParametor) {
         new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castParametor(locator, restParametor))));
    }

    public List<WebElement> waitForListElemnetVisble(WebDriver driver, String locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
    }

    public Boolean waitForElementSelected(WebDriver driver, String locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeSelected(getByLocator(locator)));
    }

    public Boolean waitForElementSelected(WebDriver driver, String locator, String... restParametor) {
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeSelected(getByLocator(castParametor(locator, restParametor))));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator, String... restParametor) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getByLocator(castParametor(locator, restParametor))));
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getByLocator(castParametor(locator, restParametor))));
    }

    public void waitForElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementPresence(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
    }

    public void waitForListElemnetPresence(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(locator)));
    }

    //Chỉ apply cho TC_07_Switch_Page
    public UserCustomerInfoPO openCustomerPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.CUSTOMER_LINK);
        clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return GeneratorPage.getUserCustomerInforPage(driver);
    }

    public UserAdressesPO openAdressesPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.ADDRESSES_LINK);
        clickToElement(driver, BasePageUI.ADDRESSES_LINK);
        return GeneratorPage.getUserAdressesPage(driver);
    }

    public UserOrderPO openOrderPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.ORDER_LINK);
        clickToElement(driver, BasePageUI.ORDER_LINK);
        return GeneratorPage.getUserOrderPage(driver);

    }


    public UserRewardPointPO openRewardPoint(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.REWARDPOINTLINK);
        clickToElement(driver, BasePageUI.REWARDPOINTLINK);
        return new UserRewardPointPO(driver);
    }

    public void sleepInSecond(long time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    
    public void clickToLinkTextByText(WebDriver driver,  String... restParametor) {
       waitForElementClickable(driver,BasePageUI.LINK_TEXT_BY_TEXT,restParametor);
       clickToElement(driver,BasePageUI.LINK_TEXT_BY_TEXT,restParametor);
    }

    public void clickToRadioByID(WebDriver driver, String... restParametor) {
        waitForElementClickable(driver,BasePageUI.RADIO_BY_ID,restParametor);
        checkTheCheckboxOrRadio(driver,BasePageUI.RADIO_BY_ID,restParametor);
    }

    public void enterToTextboxByID(WebDriver driver, String value,String... restParametor) {
        waitForElementVisible(driver,BasePageUI.TEXTBOX_BY_ID,restParametor);
        senkeyToElement(driver,BasePageUI.TEXTBOX_BY_ID,value,restParametor);

    }

    public void clickToButtonByText(WebDriver driver,String... restParametor) {
        waitForElementClickable(driver,BasePageUI.BUTTON_BY_TEXT,restParametor);
        clickToElement(driver,BasePageUI.BUTTON_BY_TEXT,restParametor);
    }

    public boolean isRadioByIDSelected(WebDriver driver,String... restParametor) {
        waitForElementSelected(driver,BasePageUI.RADIO_BY_ID,restParametor);
        return iSelementSelected(driver,BasePageUI.RADIO_BY_ID,restParametor);
    }

    public String getTextBoxAttributeValueByID(WebDriver driver,String attributeName,String... restParametor) {
        waitForElementVisible(driver,BasePageUI.TEXTBOX_BY_ID,restParametor);
       return getAttributeValue(driver,BasePageUI.TEXTBOX_BY_ID, attributeName, restParametor);
    }
}
