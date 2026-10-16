Feature: Contact Us Page Validation

  Scenario: Validate Contact Us page and Google Map
    When user clicks Contact Us
    And  Contact Us page should open
    Then Google Map should be displayed

  Scenario: Validate Contact Us form fields
    Given user is on the Contact Us page
    When user navigate through Contact us fields
    Then Name field should be displayed
    And Phone field should be displayed
    And Email field should be displayed
    And Message field should be displayed
    And Privacy checkbox should be displayed

  Scenario: Enter and validate Contact Us form details
    When user enters name, phone, email, mesaage fields
    And user selects the privacy checkbox
    Then entered form details should be correct