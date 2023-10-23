package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected static AppiumDriver driver;
    private final WebDriverWait wait;
    Clients clients = new Clients();

    public BasePage() {
        driver = clients.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private WebElement getElementBy(By elementLocator)
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    public List<WebElement> getAllElementsBy(By elementLocator)
    {
        return driver.findElements(elementLocator);
    }

    public void writeText(By elementLocator, String text) {
        getElementBy(elementLocator).clear();
        getElementBy(elementLocator).sendKeys(text);
    }

    public void clickElement(By elementLocator) {
        getElementBy(elementLocator).click();
    }

    public void clickElementFromList(WebElement element)
    {
        element.click();
    }

    public String getElementText(By elementLocator) {
        return getElementBy(elementLocator).getText();
    }

    public String getAttribute(By elementLocator, String attribute) {
        return getElementBy(elementLocator).getAttribute(attribute);
    }

    public static Object platformName() {
        return driver.getCapabilities().getCapability("platformName");
    }

    public WebElement waitUntilElementLocated(By locatorType, int maxWaitSec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitSec));

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locatorType));
    }

    public boolean elementIsDisplayed(By locatorType) {
        return getElementBy(locatorType).isDisplayed();
    }

    public boolean elementExists(By elementLocator, int maxWaitSec) {
        boolean elementDisplayed;

        try {
            elementDisplayed = waitUntilElementLocated(elementLocator, maxWaitSec).isDisplayed();
        }
        catch (TimeoutException e) {
            elementDisplayed = false;
        }

        return elementDisplayed;
    }

    public boolean elementIsSelected(By locatorType) {
        return getElementBy(locatorType).isSelected();
    }

    public boolean elementIsEnabled(By locatorType) {
        return getElementBy(locatorType).isEnabled();
    }
}