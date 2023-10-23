package pages;

import locators.LoginLocators;
import org.openqa.selenium.By;
import utils.BasePage;

import static locators.LoginLocators.modalWindowLogin;

public class LoginPage extends BasePage
{
    public Boolean homeButtonDisplayed()
    {
        return elementIsDisplayed(By.xpath(LoginLocators.homeOption));
    }

    public void writeCredentials(String email, String password)
    {
        clickElement(By.xpath(LoginLocators.loginOption));
        writeText(By.xpath(LoginLocators.userTextbox), email);
        writeText(By.xpath(LoginLocators.passwordTextbox), password);
    }

    public void pressLoginButton()
    {
        clickElement(By.xpath(LoginLocators.submitButton));
    }

    public String getLoginModalText() {
        return getElementText(By.xpath(modalWindowLogin));
    }
}