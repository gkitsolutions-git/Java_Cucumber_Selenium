@checkboxes
Feature: Checkboxes
  As a user of the-internet.herokuapp.com
  I want to interact with checkboxes
  So I can verify their default state and toggle behaviour

  @smoke
  Scenario: Verify default state of checkboxes
    Given I am on the checkboxes page
    Then checkbox 1 should be unchecked
    And checkbox 2 should be checked

  @smoke
  Scenario: Check an unchecked checkbox
    Given I am on the checkboxes page
    Then checkbox 1 should be unchecked
    When I check checkbox 1
    Then checkbox 1 should be checked

  @smoke
  Scenario: Uncheck a checked checkbox
    Given I am on the checkboxes page
    Then checkbox 2 should be checked
    When I uncheck checkbox 2
    Then checkbox 2 should be unchecked
