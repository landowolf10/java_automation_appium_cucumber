package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;

public class LoginSteps
{
    LoginPage  loginPage = new LoginPage();

    @When("entering email (.*) and password (.*)$")
    public void setUserCredentials(String email, String password)
    {
        loginPage.writeCredentials(email, password);
    }

    @And("press login button")
    public void pressLoginButton()
    {
        loginPage.pressLoginButton();
    }

    @Then("verify user successfully logged in")
    public void successfulLogin()
    {
        Assert.assertEquals("You are logged in!", loginPage.getLoginModalText());
    }

/*    public void invalidLogin()
    {
        validateInvalidLogin();
    }*/
}