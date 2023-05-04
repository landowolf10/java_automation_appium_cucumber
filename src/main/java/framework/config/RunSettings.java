package framework.config;

import java.util.HashMap;

import static framework.utils.ConstantData.*;

public class RunSettings {
    public static HashMap<String, String> loadConfig() {
        HashMap<String, String> settings = new HashMap<>();

        settings.put("automationName", automationName);
        settings.put("platformName", platformName);
        settings.put("deviceName", deviceName);
        settings.put("appPackage", appPackage);
        settings.put("appActivity", appActivity);

        return settings;
    }
}