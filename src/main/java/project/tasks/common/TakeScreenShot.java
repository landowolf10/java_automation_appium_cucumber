package project.tasks.common;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static framework.utils.BasePage.getMobileDriver;

public class TakeScreenShot
{
    public static void takeScreenShot(Scenario scenario)
    {
        TakesScreenshot ts = getMobileDriver();
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

        scenario.attach(screenshot, "image/png", "Screenshot");
    }
}