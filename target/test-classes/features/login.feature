@login
Feature: Form Authentication Login
  As a user of the-internet.herokuapp.com
  I want to log in with valid and invalid credentials
  So I can verify the authentication behaviour

  @smoke
  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter username "tomsmith" and password "SuperSecretPassword!"
    And I click the login button
    Then I should be redirected to the secure area
    And I should see a flash message containing "You logged into a secure area!"

  @smoke
  Scenario: Failed login with invalid username
    Given I am on the login page
    When I enter username "invaliduser" and password "SuperSecretPassword!"
    And I click the login button
    Then I should see a flash message containing "Your username is invalid!"

  @smoke
  Scenario: Failed login with invalid password
    Given I am on the login page
    When I enter username "tomsmith" and password "wrongpassword"
    And I click the login button
    Then I should see a flash message containing "Your password is invalid!"
