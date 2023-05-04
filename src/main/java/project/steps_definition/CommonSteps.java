package project.steps_definition;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import framework.utils.BasePage;

import static project.pages.LoginPage.homeButtonDisplayed;
import static project.tasks.common.TakeScreenShot.takeScreenShot;

public class CommonSteps extends BasePage
{
    @Given("app is open")
    public void validateAppOpen() {
        homeButtonDisplayed();
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