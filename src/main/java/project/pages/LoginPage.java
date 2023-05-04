package project.pages;

import org.openqa.selenium.By;

import static framework.utils.BasePage.*;
import static project.locators.LoginLocators.*;

public class LoginPage
{
    public static void homeButtonDisplayed()
    {
        waitUntilElementLocated(By.xpath(homeOption), 10);
    }

    public static void enterCredentials(String email, String password)
    {
        pressElement(By.xpath(loginOption), 10);
        sendText(By.xpath(userTextbox), email);
        sendText(By.xpath(passwordTextbox), password);
    }

    public static void pressLoginBtn()
    {
        pressElement(By.xpath(submitButton), 10);
    }

    /*public static void validateSuccessfulLogin()
    {
        waitUntilElementLocated(By.xpath(cartIcon), 10);
        waitUntilElementLocated(By.xpath(sortDropDown), 10);
    }*/
}