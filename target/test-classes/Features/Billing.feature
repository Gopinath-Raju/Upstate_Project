Feature: Upstate Medical Associates Billing Information

  Background:
    Given user opens the Upstate Medical Associates website

 
  Scenario: Navigate to Billing Information page
    When user clicks the Billing link
    Then the Billing Information page should open

  
  Scenario: Validate prescription fee description
    When user navigates to the Billing Information page
    Then the description for "$25.00 – Prescription Fee" should be displayed
    And the description should be "All prescriptions requested outside of visits and office hours"