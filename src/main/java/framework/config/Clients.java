package framework.config;

import io.appium.java_client.AppiumDriver;
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

        //capabilities.setCapability("automationName", runSettings.get("automationName"));
        capabilities.setCapability("platformName", runSettings.get("platformName"));
        capabilities.setCapability("deviceName", runSettings.get("deviceName"));
        capabilities.setCapability("appPackage", runSettings.get("appPackage"));
        capabilities.setCapability("appActivity", runSettings.get("appActivity"));
        capabilities.setCapability("autoGrantPermissions", true);

        try {
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
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