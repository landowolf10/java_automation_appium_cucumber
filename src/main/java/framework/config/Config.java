package framework.config;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Config extends DesiredCapabilities
{
    public static AppiumDriver driver = null;
    public static boolean instanceExists = false;
}