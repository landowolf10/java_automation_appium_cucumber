package runners;

import io.appium.java_client.AppiumDriver;
import io.cucumber.testng.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BasePage;
import utils.Clients;

@CucumberOptions(
        features = "src/test/resources/features/login/login.feature",
        glue = "steps",
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:target/cucumber-report.json"
        }
)
public class LoginRunner extends AbstractTestNGCucumberTests{

}
