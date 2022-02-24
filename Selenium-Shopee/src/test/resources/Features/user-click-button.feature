# Author : Shah Ridzuan



@SmokeScenario
Feature: feature to test click button
  @SmokeTest
  Scenario: Check user able to click button

    Given user is on home page
    When user at home page
    Then user nagivigate to button page
    And click button
    And user navigate back to home page

  Scenario Outline: Check user able to click multiple button

    Given user is on login page
    When user enters <username> and <password>
    And click login button
    Then user navigate to home page

    Examples:
    |username|password|
    |user1   |pass1   |
    |user2   |pass2   |

