Feature: Upstate Medical Associates Providers Page

  Background:
    Given user opens the Upstate Medical Associates website

 
  Scenario: Navigate to Providers page
    When user clicks the Providers link
    Then the Providers page URL should contain "meet-our-providers"


  Scenario Outline: Validate provider names are displayed
    When user navigates to the Providers page
    Then the provider name "<providerName>" should be displayed

    Examples:
      | providerName          |
      | Jared Richardson, MD  |
      | Nancy Smith, FNP-C    |
      | Jessica Jones, PA-C   |
      | Ali Lawing, FNP-C     |