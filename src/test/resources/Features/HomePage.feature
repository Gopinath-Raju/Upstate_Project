Feature: user need to navigate and verify the options in Upstate Medical Associates Home Page

  Background:
    Given user opens the Upstate Medical Associates website

  
  Scenario: Verify the page title and Handle contact number alert
    When  user need to verify page title
    And  user clicks the contact number section
    Then user should be able to dismiss the alert

 
  Scenario: Validate Leave A Review form
    When user clicks the Leave A Review link
    And user switches to the review window
    And user clicks the Contact Directly button
    And user filled all the fields
    Then the review form fields should contain the entered values
