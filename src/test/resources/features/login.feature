#Author: arunsiddhu1992@gmail.com
@amazon
Feature: login to the app

  @ValidLogin
  Scenario: login to the app
    Given user is present on login screen
    When user enters valid email id
    And user clicks on continue
    And user enters valid password
    And user clicks on login
    Then verify if user is logged in