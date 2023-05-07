package framework.config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import static framework.config.Config.instanceExists;
import static framework.config.RunSettings.loadConfig;

public class Clients {
    AppiumDriver driver;

    public AppiumDriver getDriver() {
        if (instanceExists)
            driver = Config.driver;
        else
            driver = createDriver();

        instanceExists = true;
        Config.driver = driver;

        return driver;
    }

    private AppiumDriver createDriver() {
        HashMap<String, String> runSettings = loadConfig();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        UiAutomator2Options options = new UiAutomator2Options();
        String userName = "orlandoavila_ve9kqN";
        String accessKey = "LPbotyHHmZWvyWnkxnPH";

        //Local
        /*capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, runSettings.get("platformName"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, runSettings.get("platformVersion"));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, runSettings.get("deviceName"));
        capabilities.setCapability("app", runSettings.get("app"));*/

        //BrowserStack
        options.setCapability("appium:app", runSettings.get("app"));
        options.setCapability("appium:deviceName", "Samsung Galaxy S22 Ultra");
        options.setCapability("appium:platformVersion", "12.0");

        try {
            //driver = new AppiumDriver(new URL("http://hub.browserstack.com/wd/hub"), capabilities);
            driver = new AppiumDriver(new URL(String.format("https://%s:%s@hub.browserstack.com/wd/hub", userName , accessKey)), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }

    public void killDriver() {
        WebDriver currentDriver = null;

        if (instanceExists)
        {
            currentDriver = Config.driver;
            currentDriver.quit();
        }

        instanceExists = false;
        Config.driver = null;
    }
}