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
    Then the <field> corresponding to the selected record should be displayed

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


  Scenario: Table header columns are displayed in the correct order
    When User clicks the View Previous Test Reports button for a specific record
    Then the headers should appear in the exact order: Record Number → File → Uploaded Time → File/Report Name → Vitals → Identified Health Conditions


  Scenario Outline: Each report row displays the correct data field
    When User clicks the View Previous Test Reports button for a specific record
    Then each report row should display "<data_field>"

    Examples:
      | data_field                   |
      | a Record Number              |
      | a View PDF button            |
      | the Uploaded Time            |
      | the File/Report Name         |
      | Vitals information           |
      | Identified Health Conditions |

  Scenario: Vitals are displayed in the correct order
    When User clicks the View Previous Test Reports button for a specific record
    Then Vitals should be displayed in the order: Weight → Height → Temperature → SP → DP


  Scenario: Vitals are displayed in multiline format
    When User clicks the View Previous Test Reports button for a specific record
    Then Vitals should be displayed in multiline format


  Scenario: Identified health conditions are displayed in multiline format
    When User clicks the View Previous Test Reports button for a specific record
    Then Identified Health Conditions should be displayed in multiline format


  Scenario: Corresponding PDF report opens for a record
    Given User is on the View Patient Test Reports page
    When User clicks the View PDF button for a particular record
    Then the corresponding PDF report for that record should be opened
 

  Scenario: Pagination count is updated correctly after navigation
    Given User is on the View Patient Test Reports page
    When User clicks any page navigation arrow
    Then the pagination text should display the correct range and total number of records

  Scenario: Pagination controls are displayed when records exceed one page
    Given User is on the View Patient Test Reports page
    When User navigates to any page
    Then the pagination controls should be displayed

  Scenario Outline: Navigate using pagination arrow
    Given User is on the View Patient Test Reports page
    When User clicks the "<arrow>" arrow
    Then "<expected_result>"

    Examples:
      | arrow           | expected_result                                         |
      | Next (>)        | the next set of patient records should be displayed     |
      | Previous (<)    | the previous set of patient records should be displayed |
      | First page (<<) | the first page of patient records should be displayed   |
      | Last page (>>)  | the last page of patient records should be displayed    |

  Scenario Outline: Pagination arrow state on the first page
    Given User is on the View Patient Test Reports page
    When User navigates to the first page
    Then the "<arrow>" should be "<state>"

    Examples:
      | arrow           | state    |
      | Previous (<)    | disabled |
      | First page (<<) | disabled |
      | Next (>)        | enabled  |
      | Last page (>>)  | enabled  |


  Scenario Outline: Pagination arrow state on a middle page
    Given User is on the View Patient Test Reports page
    When User navigates to any page after the first page
    Then the "<arrow>" should be "<state>"

    Examples:
      | arrow           | state   |
      | Previous (<)    | enabled |
      | First page (<<) | enabled |


  Scenario Outline: Pagination arrow state on pages before the last page
    Given User is on the View Patient Test Reports page
    When User navigates to any page except the last page
    Then the "<arrow>" should be "<state>"

    Examples:
      | arrow          | state   |
      | Next (>)       | enabled |
      | Last page (>>) | enabled |


  Scenario Outline: Pagination arrow state on the last page
    Given User is on the View Patient Test Reports page
    When User navigates to the last page
    Then the "<arrow>" should be "<state>"

    Examples:
      | arrow          | state    |
      | Next (>)       | disabled |
      | Last page (>>) | disabled |

  Scenario: Each page displays only 2 records at a time
    Given User is on the View Patient Test Reports page
    When User views any page of the Reports table
    Then only 2 records should be visible on that page

  Scenario Outline: All pagination arrows are disabled when only one page exists
    Given User is on the View Patient Test Reports page
    When User views the pagination controls
    Then the "<arrow>" should be disabled

    Examples:
      | arrow        |
      | First (<<)   |
      | Previous (<) |
      | Next (>)     |
      | Last (>>)    |
 

  Scenario: Pagination text shows zero records when no data exists
    Given User is on the View Patient Test Reports page
    When User views the pagination controls
    Then "Showing 0 to 0 of 0 patients" should be displayed


  Scenario Outline: All pagination arrows are disabled when no data exists
    Given User is on the View Patient Test Reports page
    When User views the pagination controls
    Then the "<arrow>" should be disabled

    Examples:
      | arrow        |
      | First (<<)   |
      | Previous (<) |
      | Next (>)     |
      | Last (>>)    |


  