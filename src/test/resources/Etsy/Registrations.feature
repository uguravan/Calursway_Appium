Feature: Registration Tests

  Scenario: Successful registration
    Given I am on the registration page
    When I enter a valid email
    And I click on the continue button
    When I enter firstName and password
    And I  click on register button
    Then I should be on home page