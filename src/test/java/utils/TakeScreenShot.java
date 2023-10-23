package utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static utils.ConstantData.driver;


public class TakeScreenShot
{
    public static void takeScreenShot(Scenario scenario)
    {
        if (scenario.isFailed())
        {
            TakesScreenshot ts = driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "Screenshot");
        }
    }
}