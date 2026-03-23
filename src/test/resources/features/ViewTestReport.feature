Feature: Patient Information Section

  Background:
    Given User is logged into the app
    And patients already exist in the system

  Scenario: Correct report opens for selected record
    Given User is on the My Patients page
    When User clicks the View Previous Test Reports button for a specific record
    Then the corresponding report for that record should be opened

  Scenario: Title is displayed
    Given User is on the My Patients page
    When User clicks the View Previous Test Reports button for a specific record
    Then the title "View Patient Test Reports" should be displayed

  Scenario: Close icon is displayed
    Given User is on the My Patients page
    When User clicks the View Previous Test Reports button for a specific record
    Then the Close icon "X" should be displayed

  Scenario Outline: Patient information field is displayed
    Given User is on the My Patients page
    When User clicks the View Previous Test Reports button for a specific record
    Then the <field> corresponding to the selected record should be displayed

    Examples:
      | field          |
      | Patient Id     |
      | Patient Name   |
      | Patient Email  |
      | Contact Number |

# View Patient Test Reports - Table

  Scenario: Report table is displayed
    Given User is on the My Patients page
    When User clicks the View Previous Test Reports button for a specific record
    Then the Reports table should be displayed

  Scenario: Pagination controls are displayed
    Given User is on the My Patients page
    When User clicks the View Previous Test Reports button for a specific record
    Then the pagination controls First (<<), Previous (<), Next (>), Last (>>) arrows should be displayed

  Scenario Outline: Table header column is displayed
    Given User is on the My Patients page
    When User clicks the View Previous Test Reports button for a specific record
    Then the table header "<header>" should be displayed

    Examples:
      | header                    |
      | Record Number             |
      | File                      |
      | Uploaded Time             |
      | File/Report Name          |
      | Vitals                    |
      | Identified Health Conditions |

  Scenario: Table header columns are in the correct order
    Given User is on the My Patients page
    When User clicks the View Previous Test Reports button for a specific record
    Then the headers should appear in the exact order: Record Number → File → Uploaded Time → File/Report Name → Vitals → Identified Health Conditions

# Reports Table Data Scenarios

  Scenario Outline: Each report row displays the correct data field
    Given User is on the My Patients page
    When User clicks the View Previous Test Reports button for a specific record
    Then each report row should display <data_field>

    Examples:
      | data_field                    |
      | a Record Number               |
      | a View PDF button             |
      | the Uploaded Time             |
      | the File/Report Name          |
      | Vitals information            |
      | Identified Health Conditions  |

  Scenario: Vitals are displayed in the correct order
    Given User is on the My Patients page
    When User clicks the View Previous Test Reports button for a specific record
    Then Vitals should be displayed in the order: Weight → Height → Temperature → SP → DP

  Scenario: Vitals are displayed in multiline format
    Given User is on the My Patients page
    When User clicks the View Previous Test Reports button for a specific record
    Then Vitals should be displayed in multiline format

  Scenario: Identified health conditions are displayed in multiline format
    Given User is on the My Patients page
    When User clicks the View Previous Test Reports button for a specific record
    Then Identified Health Conditions should be displayed in multiline format
