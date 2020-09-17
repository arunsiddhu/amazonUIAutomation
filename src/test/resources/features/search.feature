#Author: arunsiddhu1992@gmail.com
@amazon
Feature: search for items

  Background: User is logged in app
    Given user is present on login screen
    When user enters valid email id
    And user clicks on continue
    And user enters valid password
    And user clicks on login
    Then verify if user is logged in

  @searchAndPurchase
  Scenario Outline: search for items
    Given user searches for <query>
    And user presses enter
    When user selects random item
    And adds item to cart
    Then goto cart
    And purchase the item

    Examples: 
      | query      |
      | 65-inch TV |