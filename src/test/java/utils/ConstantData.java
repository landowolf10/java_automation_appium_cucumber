package utils;

import io.appium.java_client.AppiumDriver;

public class ConstantData {
    public static String automationName = "UiAutomator2";
    public static String platformName = "Android";
    public static String platformVersion = "11";
    public static String deviceName = "Pixel 5";
    public static String appPackage = "com.wdiodemoapp";
    public static String appActivity = "com.wdiodemoapp.MainActivity";
    public static String app = "bs://aef7e6a41040ce0d9979b7dcfe6dadd8da915fb7";
    public static AppiumDriver driver = null;
    public static boolean instanceExists = false;
}