package com.theinternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

    private static final String URL = "https://the-internet.herokuapp.com/dropdown";

    @FindBy(id = "dropdown")
    private WebElement dropdownElement;

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public void navigate() {
        driver.get(URL);
    }

    public void selectOption(String optionText) {
        waitForVisibility(dropdownElement);
        new Select(dropdownElement).selectByVisibleText(optionText);
    }

    public String getSelectedOption() {
        return new Select(dropdownElement).getFirstSelectedOption().getText();
    }
}
