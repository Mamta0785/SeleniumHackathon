Feature: Add Patient Dialog Box - Validation

  Background: User logged into Application, clicks on New Patient
    Given User is in Home Page
    When User clicks on New Patient in the header section

  Scenario: Title of the dialog box
    Then User should see Add Patient Details on the dialog box
