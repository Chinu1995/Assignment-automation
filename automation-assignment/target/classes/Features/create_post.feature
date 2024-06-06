Feature: Create a new post

  Scenario: Create a new post with a subscription and non-subscription price
    Given user is on login page
    When user logs in with email "testqa@mailinator.com" and password "123456789"
    And user navigates to new post page
    Then user sets subscription and non-subscription prices to "5"
    And user verifies that post button is enabled for price "5"
    And user submits the post
    Then post should be successfully created
