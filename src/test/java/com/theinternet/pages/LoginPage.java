package com.theinternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private static final String URL = "https://the-internet.herokuapp.com/login";

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(id = "flash")
    private WebElement flashMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigate() {
        driver.get(URL);
    }

    public void enterUsername(String username) {
        type(usernameField, username);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public String getFlashMessageText() {
        waitForVisibility(flashMessage);
        return flashMessage.getText();
    }

    public boolean isLoginSuccessful() {
        try {
            wait.until(ExpectedConditions.urlContains("/secure"));
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }
}
