package com.theinternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckboxesPage extends BasePage {

    private static final String URL = "https://the-internet.herokuapp.com/checkboxes";

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> checkboxes;

    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    public void navigate() {
        driver.get(URL);
    }

    public boolean isCheckboxChecked(int index) {
        return checkboxes.get(index - 1).isSelected();
    }

    public void checkCheckbox(int index) {
        WebElement checkbox = checkboxes.get(index - 1);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void uncheckCheckbox(int index) {
        WebElement checkbox = checkboxes.get(index - 1);
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }
}
