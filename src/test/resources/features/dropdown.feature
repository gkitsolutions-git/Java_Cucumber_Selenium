@dropdown
Feature: Dropdown
  As a user of the-internet.herokuapp.com
  I want to select options from a dropdown
  So I can verify the selection behaviour

  @smoke
  Scenario: Select Option 1 from the dropdown
    Given I am on the dropdown page
    When I select "Option 1" from the dropdown
    Then "Option 1" should be the selected option

  @smoke
  Scenario: Select Option 2 from the dropdown
    Given I am on the dropdown page
    When I select "Option 2" from the dropdown
    Then "Option 2" should be the selected option

  @smoke
  Scenario: Switch selection between options
    Given I am on the dropdown page
    When I select "Option 1" from the dropdown
    Then "Option 1" should be the selected option
    When I select "Option 2" from the dropdown
    Then "Option 2" should be the selected option
