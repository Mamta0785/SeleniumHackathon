@Login
Feature: View Patient Test Reports

  Background: User is successfully logged into the application
    Given User is on the "MyPatients" page


  Scenario: Correct report opens for the selected record
    When User clicks the View Previous Test Reports button for a specific record
    Then the corresponding report for that record should be opened

  Scenario: Title is displayed on the View Patient Test Reports page
    When User clicks the View Previous Test Reports button for a specific record
    Then the title "View Patient Test Reports" should be displayed


  Scenario: Close icon is displayed on the View Patient Test Reports page
    When User clicks the View Previous Test Reports button for a specific record
    Then the Close icon "X" should be displayed


  Scenario Outline: Patient information field is displayed
    When User clicks the View Previous Test Reports button for a specific record
    Then the "<field>" corresponding to the selected record should be displayed

    Examples:
      | field          |
      | Patient Id     |
      | Patient Name   |
      | Patient Email  |
      | Contact Number |


  Scenario: Report table is displayed
    When User clicks the View Previous Test Reports button for a specific record
    Then the Reports table should be displayed


  Scenario: Pagination controls are displayed
    When User clicks the View Previous Test Reports button for a specific record
    Then the pagination controls First , Previous , Next , Last  arrows should be displayed


  Scenario Outline: Each table header column is displayed
    When User clicks the View Previous Test Reports button for a specific record
    Then the table header "<header>" should be displayed

    Examples:
      | header                       |
      | Record Number                |
      | File                         |
      | Uploaded Time                |
      | File/Report Name             |
      | Vitals                       |
      | Identified Health Conditions |

  Scenario: Vitals are displayed in the correct order
    When User clicks the View Previous Test Reports button for a specific record
    Then Vitals should be displayed in the order: Weight → Height → Temperature → SP → DP


  




