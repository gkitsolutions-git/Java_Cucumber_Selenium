package com.theinternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CheckboxesPage extends BasePage {

    private static final String URL = "https://the-internet.herokuapp.com/checkboxes";
    private static final By CHECKBOX_LOCATOR = By.cssSelector("input[type='checkbox']");

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> checkboxes;

    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    public void navigate() {
        driver.get(URL);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(CHECKBOX_LOCATOR, 1));
    }

    private WebElement getCheckbox(int index) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(CHECKBOX_LOCATOR, 1));

        int zeroBasedIndex = index - 1;
        if (zeroBasedIndex < 0 || zeroBasedIndex >= checkboxes.size()) {
            throw new IllegalArgumentException(
                "Invalid checkbox index: " + index + ". Available checkboxes: " + checkboxes.size());
        }

        return checkboxes.get(zeroBasedIndex);
    }

    public boolean isCheckboxChecked(int index) {
        return getCheckbox(index).isSelected();
    }

    public void checkCheckbox(int index) {
        WebElement checkbox = getCheckbox(index);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void uncheckCheckbox(int index) {
        WebElement checkbox = getCheckbox(index);
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }
}
