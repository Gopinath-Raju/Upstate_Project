Feature: Services Page Validation

  Scenario: Validate General Healthcare page
    Given user opens the Upstate Medical Associates website
    When user clicks the Services menu
    And user clicks General Healthcare
    Then General Healthcare page should open
    
     Scenario: Validate FAQs
    Given user navigate to FAQs section
    When user clicks the third FAQ
    Then the third FAQ answer should be displayed