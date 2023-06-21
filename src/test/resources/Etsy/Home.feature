Feature: Home Page Tests

  Scenario:Updating content after refresh page

    When I click on continue as guest button
    And I click on maybe later button
    When I refresh page
    Then I verify page content has been updated