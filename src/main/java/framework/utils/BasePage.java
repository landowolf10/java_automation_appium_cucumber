package framework.utils;

import framework.config.Clients;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage extends Clients {
    static RemoteWebDriver driver;

    public BasePage() {
        driver = getDriver();
    }

    public static RemoteWebDriver getMobileDriver() {
        return driver;
    }

    public static WebElement getElementBy(By locatorType) {
        return waitUntilElementLocated(locatorType, 10);
    }

    public static void pressElement(By elementLocator, int waitAfterClick) {
        getElementBy(elementLocator).click();
        getMobileDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(waitAfterClick));
    }

    public static void sendText(By elementLocator, String text) {
        WebElement element = getElementBy(elementLocator);
        element.clear();
        element.sendKeys(text);
    }

    public void getText(By elementLocator, String attribute) {
        WebElement element = getElementBy(elementLocator);
        element.getAttribute(attribute);
    }

    public String getAttribute(By elementLocator, String text) {
        WebElement element = getElementBy(elementLocator);
        return element.getText();
    }

    public static boolean elementExists(By elementLocator, int maxWaitSec) {
        boolean elementDisplayed;

        try {
            elementDisplayed = waitUntilElementLocated(elementLocator, maxWaitSec).isDisplayed();
        }
        catch (TimeoutException e) {
            elementDisplayed = false;
        }

        return elementDisplayed;
    }

    public static Object platformName() {
        return getMobileDriver().getCapabilities().getCapability("platformName");
    }

    public static WebElement waitUntilElementLocated(By locatorType, int maxWaitSec) {
        return waitUntil(ExpectedConditions.visibilityOfElementLocated(locatorType), maxWaitSec);
    }

    private List<WebElement> waitUntilElementsLocated(WebElement elements) {
        return waitUntilElements(ExpectedConditions.visibilityOfAllElements(elements), 10);
    }

    private WebElement waitUntilClickable(By locatorType) {
        return waitUntil(ExpectedConditions.elementToBeClickable(locatorType), 10);
    }

    public static WebElement waitUntil(ExpectedCondition<WebElement> condition, int maxWaitSec) {
        WebDriverWait wait = new WebDriverWait(getMobileDriver(), Duration.ofSeconds(maxWaitSec));

        return wait.until(condition);
    }

    private List<WebElement> waitUntilElements(ExpectedCondition<List<WebElement>> condition, int maxWaitSec) {
        WebDriverWait wait = new WebDriverWait(getMobileDriver(), Duration.ofSeconds(maxWaitSec));


        return wait.until(condition);
    }
}