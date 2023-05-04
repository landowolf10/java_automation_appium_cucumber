package project.steps_definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import framework.utils.BasePage;

import static project.pages.LoginPage.*;

public class LoginSteps extends BasePage
{
    @When("entering email (.*) and password (.*)$")
    public void setUserCredentials(String email, String password)
    {
        enterCredentials(email, password);
    }

    @And("press login button")
    public void pressLoginButton()
    {
        pressLoginBtn();
    }

    /*@Then("verify user successfully logged in")
    public void successfulLogin()
    {
        validateSuccessfulLogin();
    }

    @Then("verify user login was not successful")
    public void invalidLogin()
    {
        validateInvalidLogin();
    }*/
}