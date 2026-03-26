@MyPatiens @LoginFeature
Feature: My Patients Page Functionality
Background: User is successfully logged into the application
Given User is on the "My Patients" page

Scenario: Title is displayed
Then Page header "My Patients" should be displayed

Scenario: Search bar display
Then Search bar should be displayed 

Scenario: Search icon display
Then Search icon should be displayed inside the search bar
 
Scenario: Search placeholder text display
Then Placeholder text "Search..." should be displayed

Scenario: Table column header
Then Table should have column headers with text
    | Patient Id |
    | Name       |
	| Details |
	| Last Visit Date |
	| Actions |
	| Edit/Delete |
	    
Scenario: column sorting icon
Then Up and down arrow icons should be displayed in the "<column>" header
    Examples:
        | column          |
        | Patient Id      |
        | Name            |
     
Scenario: patients list display when patients record is alredy exist in the system
Then user should see the values in all coulmns of the table for each patient record

Scenario Outline: Verify column values are present when patients record  alredy exist in the system
Then "<column name>" values should be displayed for each patient record
  Examples:
    | column name       |
    | Patient Id        |
    | Name              |
    | Last Visit Date   |
    
Scenario: Details column displays patient information when patients record  alredy exist in the system
Then Details column should display below details for each patient record
	| phone number |
	| email        |
	| date of birth |

Scenario: Details are displayed in multiline format record when patients record  alredy exist in the system
Then Phone number, email , date of birth should be displayed on separate lines for each patient record

Scenario Outline: details formats in details column when patients record  alredy exist in the system
Then "<details>" in details column should be displayed in correct "<format>" for each patient record
  Examples:
    | details         | format |
    | phone number  | valid numeric digits |
    | email         | valid email format |
    | date of birth | MM/DD/YYYY |


Scenario: last visit date format when patients record  alredy exist in the system
Then Last visit date should be displayed in correct format MM/DD/YYYY for each patient record

Scenario: buttons under action column display when patients record  alredy exist in the system
Then button should be displayed under action column for each patient record
    | View Previous Test Reports |
    | View Previous diet Plans |
    | Create New Report/Plan |

Scenario Outline: Action icons displayed for each row when patient records exist
Then "<icon>" icon should be displayed for each patient record
Examples:
  | icon   |
  | Edit   |
  | Delete |

Scenario Outline: sorting functionality for different columns when patients record  alredy exist in the system
When User clicks "<arrow>" arrow in "<column>" column
Then Patient records should be sorted in "<order>" order for "<column>"

Examples:
| column      | arrow | order       |
| Patient Id  | up    | ascending   |
| Patient Id  | down  | descending  |
| Name        | up    | ascending   |
| Name        | down  | descending  |

Scenario Outline: search functionality using different inputs when patients record  alredy exist in the system
When User searches using "<input>"
Then Matching patient details should be displayed

Examples:
| input  |
| patient name  |
| patient id    |

Scenario: Search is cleared when patients record  alredy exist in the system
When user enters text in search bar and then clears the search input
Then All patient records should be displayed again in the table

Scenario Outline: navigation using pagination arrows when multiple patients records already exist in the system
When User clicks "<arrow>" from pagination arrow
Then "<expected_page>" page of patient records should be displayed

Examples:
| arrow | expected_page |
| >     | next        |
| <     | previous    |
| >>    | first       |
| <<    | last        |

Scenario: Verify pagination count is updated
  Given the user is on any page of "My Patients"
  When the user navigates using pagination
  Then pagination text should display correct range and total number of patients
  
Scenario Outline: Verify pagination arrow states when multiple patient records already exist in the system for that user
  When  the user is on "<page>" of My Patients page with multiple pages of patient records
  Then "<arrow>" arrow should be "<state>"

Examples:
  | page                      | arrow | state    |
  | first page                | <     | disabled |
  | first page                | <<    | disabled |
  | first page                | >     | enabled  |
  | first page                | >>    | enabled  |
  | last page                 | >     | disabled |
  | last page                 | >>    | disabled |
  | any page after first page | <     | enabled  |
  | any page after first page | <<    | enabled  |
  | any page before last page | >     | enabled  |
  | any page before last page | >>    | enabled  |


Scenario: All pagination arrows disabled when only one pataient data page exists
Then First, previous, next, last arrows should be disabled

Scenario: Pagination when no patient data exists
Then "Showing 0 to 0 of 0 patients" text should be displayed

Scenario: All pagination arrows disabled when no patient data exists
Then First, previous, next, last arrows should be disabled

Scenario: Each page should display only 5 records when maximum 5 patient record is displayed
Then User should see only 5 records in each page

Scenario: Newly added record move to the next page when 6th record is added when maximum 5 patient record is displayed 
When User adds 6th record
Then User should see the newly added record in the next page

Scenario: Navigation of View Previous Test Reports when patient data already exist in the sysytem for that user 
Then User should be navigated to "View Patient Test Reports" page

Scenario: My Patient page loads with empty table when there is no patient record in the system
Then My Patients page should display with empty table
 



	