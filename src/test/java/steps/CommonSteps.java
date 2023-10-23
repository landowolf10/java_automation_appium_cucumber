package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.LoginPage;
import static utils.Clients.killDriver;
import static utils.TakeScreenShot.takeScreenShot;

public class CommonSteps
{
    LoginPage loginPage = new LoginPage();

    @Given("I open the app")
    public void validateAppOpen() {
        Assert.assertTrue(loginPage.homeButtonDisplayed());
    }

    @AfterStep
    public void screenShot(Scenario scenario) {
        takeScreenShot(scenario);
    }

    @After
    public void closeDriver() {
        killDriver();
    }
}
