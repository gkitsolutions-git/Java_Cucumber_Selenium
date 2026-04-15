package com.theinternet.stepdefinitions;

import com.theinternet.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    private LoginPage loginPage;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.navigate();
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the secure area")
    public void i_should_be_redirected_to_the_secure_area() {
        Assert.assertTrue("User should be redirected to secure area", loginPage.isLoginSuccessful());
    }

    @Then("I should see a flash message containing {string}")
    public void i_should_see_a_flash_message_containing(String expectedText) {
        String actualMessage = loginPage.getFlashMessageText();
        Assert.assertTrue(
            "Flash message should contain: " + expectedText + " but was: " + actualMessage,
            actualMessage.contains(expectedText));
    }
}
