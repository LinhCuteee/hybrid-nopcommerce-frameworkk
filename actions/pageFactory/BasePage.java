package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public void clickToElement(WebElement element) {
        element.click();
    }

    public void senkeyToElement(WebElement element, String keyToSend) {
        element.clear();
        element.sendKeys(keyToSend);
    }

    public String getAttributeValue(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    public String getTextElement(WebElement element) {
        return element.getText();
    }

    public void checkTheCheckboxOrRadio(WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }
    }

    public Boolean isElementDisplay(WebElement element) {
        return element.isDisplayed();
    }

    public Boolean iselementSelected(WebElement element) {
        return element.isSelected();
    }

    public WebElement waitForElementVisible( WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementClickable( WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public Boolean waitForElementSelected(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeSelected(element));
    }
}
