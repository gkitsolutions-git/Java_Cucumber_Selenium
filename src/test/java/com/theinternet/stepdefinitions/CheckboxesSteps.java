package com.theinternet.stepdefinitions;

import com.theinternet.pages.CheckboxesPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CheckboxesSteps {

    private CheckboxesPage checkboxesPage;

    @Given("I am on the checkboxes page")
    public void i_am_on_the_checkboxes_page() {
        checkboxesPage = new CheckboxesPage(DriverManager.getDriver());
        checkboxesPage.navigate();
    }

    @Then("checkbox {int} should be unchecked")
    public void checkbox_should_be_unchecked(int index) {
        Assert.assertFalse("Checkbox " + index + " should be unchecked",
            checkboxesPage.isCheckboxChecked(index));
    }

    @Then("checkbox {int} should be checked")
    public void checkbox_should_be_checked(int index) {
        Assert.assertTrue("Checkbox " + index + " should be checked",
            checkboxesPage.isCheckboxChecked(index));
    }

    @When("I check checkbox {int}")
    public void i_check_checkbox(int index) {
        checkboxesPage.checkCheckbox(index);
    }

    @When("I uncheck checkbox {int}")
    public void i_uncheck_checkbox(int index) {
        checkboxesPage.uncheckCheckbox(index);
    }
}
