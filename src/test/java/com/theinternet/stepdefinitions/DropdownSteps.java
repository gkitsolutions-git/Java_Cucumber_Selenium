package com.theinternet.stepdefinitions;

import com.theinternet.pages.DropdownPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DropdownSteps {

    private DropdownPage dropdownPage;

    @Given("I am on the dropdown page")
    public void i_am_on_the_dropdown_page() {
        dropdownPage = new DropdownPage(DriverManager.getDriver());
        dropdownPage.navigate();
    }

    @When("I select {string} from the dropdown")
    public void i_select_from_the_dropdown(String option) {
        dropdownPage.selectOption(option);
    }

    @Then("{string} should be the selected option")
    public void should_be_the_selected_option(String expectedOption) {
        Assert.assertEquals("Dropdown selected option mismatch",
            expectedOption, dropdownPage.getSelectedOption());
    }
}
