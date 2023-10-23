package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static utils.ConstantData.instanceExists;

public class Clients {
    AppiumDriver driverInstance;

    public AppiumDriver getDriver() {
        if (instanceExists)
            driverInstance = ConstantData.driver;
        else
            driverInstance = createDriver();

        instanceExists = true;
        ConstantData.driver = driverInstance;

        return driverInstance;
    }

    private AppiumDriver createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String userName = "orlandoavila_iF6cDC";
        String accessKey = "6ZHLXXnpAwDetaZAkkxp";

        //Local Android
        /*capabilities.setCapability("automationName", ConstantData.automationName);
        capabilities.setCapability("platformName", ConstantData.platformName);
        capabilities.setCapability("deviceName", ConstantData.deviceName);
        capabilities.setCapability("appPackage", ConstantData.appPackage);
        capabilities.setCapability("appActivity", ConstantData.appActivity);
        capabilities.setCapability("autoGrantPermissions", true);*/

        //BrowserStack Android
        capabilities.setCapability("app", ConstantData.app);
        capabilities.setCapability("deviceName", "Samsung Galaxy S22 Ultra");
        capabilities.setCapability("platformVersion", "12.0");

        try {
            //driverInstance = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driverInstance = new AppiumDriver(new URL(String.format("https://%s:%s@hub.browserstack.com/wd/hub", userName,
                    accessKey)), capabilities   );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driverInstance;
    }

    /*public WebDriverWait initializeWait()
    {
        wait = new WebDriverWait(driverInstance, Duration.ofSeconds(10));
        return wait;
    }*/

    public static void killDriver() {
        WebDriver currentDriver = null;

        if (instanceExists)
        {
            currentDriver = ConstantData.driver;
            currentDriver.quit();
        }

        instanceExists = false;
        ConstantData.driver = null;
    }
}