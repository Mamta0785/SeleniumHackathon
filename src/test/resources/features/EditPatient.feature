Feature:Edit Patient Dialog Box Validation

Background:
Given User logged into the app 
And patients already exists

Scenario: Title of the dialoge box
Given User is in my patient page
When User clicks edit icon for the particular patient 
Then User should see  Edit Patient page on the dialog box

Scenario: Presence of Submit button
Given User is in my patient page
When User clicks edit icon for the particular patient 
Then User should see  submit button

Scenario: State of submit button
Given User is in my patient page
When User clicks edit icon for the particular patient 
Then User should see submit button in enable mode

Scenario: Presence of Close button
Given User is in my patient page
When User clicks edit icon for the particular patient 
Then  User should see  Close button

Scenario: State of Close button
Given User is in my patient page
When User clicks edit icon for the particular patient 
Then  User should see close button in enable mode

Scenario Outline: Presence of 9 Input field 
Given User is in my patient page
When User clicks edit icon for the particular patient 
Then  User should see 9 "<input field>"

Examples:
|Input Field	|
|First name		|
|Last name		|
|Email			|
|Conatct Number	|
|Weight			|
|Height			|
|Temperature	|
|SP				|
|DP				|


Scenario Outline: Presence of 3 drop down
Given User is in my patient page
When User clicks edit icon for the particular patient 
Then  User should see 3 "<drop down>"

Examples:
|dropdown		|
|Allergies		 |
|Food Preference |
|Cuisine Category|


Scenario: Presence of file upload option
Presence of file upload option
Given User is in my patient page
When User clicks edit icon for the particular patient 
Then  User should see exactly 1 file upload option

Scenario: Presence of first name of the patient
Given User is in my patient page
When User clicks edit icon for the particular patient 
Then  User should see the ‘First Name’ field populated with the value entered during patient creation.

Scenario: Presence of last name of the patient
Given User is in my patient page
When User clicks edit icon for the particular patient 
Then  User should see the "Last Name" field populated with the value entered during patient creation

Scenario: Presence of Email of the patient
Given User is in my patient page
When User clicks edit icon for the particular patient 
Then User should see the "Email" field populated with the value entered during patient creation


Scenario: Presence of Contact Number  of the patient
Given User is in my patient page
When User clicks edit icon for the particular patient 
Then  User should see the "Contact Number" field populated with the value entered during patient creation

Scenario: Presence of patients food preference
Given User is in my patient page
When User clicks edit icon for the particular patient 
Then  User should see the "Food Preference" field populated with the value entered during patient creation

Scenario: Presence of patients cuisine preference
Given User is in my patient page
When User clicks edit icon for the particular patient 
Then  User should see the "Cuisine Category" field populated with the value entered during patient creation

Scenario: Presence of patients DOB info
Given User is in my patient page
When User clicks edit icon for the particular patient 
Then  User should see the "Date of Birth" field populated with the value entered during patient creation


Scenario: Presence of sub titleVitals 
Given User is in my patient page
When User clicks edit icon for the particular patient 
Then User should see vitals title after DOB field
# not added after SP field test case

Scenario:Presence of place holder in First Name 
Given : User is on My Patient page
And User clicks edit icon for a particular patient
And User is on Edit Patient dialog box
When User clears existing value in First Name field 
Then User should see placeholder "First Name"


Scenario:Presence of place holder in Last Name 
Given : User is on My Patient page
And User clicks edit icon for a particular patient
And User is on Edit Patient dialog box
When User clears existing value in Last Name field 
Then User should see placeholder "Last Name"

Scenario:Edit first name with spl charac & numeric data
Given : User is on My Patient page
And User clicks edit icon for a particular patient
And User is on Edit Patient dialog box
When User clicks submit after editing first name with spl numeric data 
Then User should  see error message in Patient name accepts only alphabets

Scenario:Edit first name with spl charac data
Given : User is on My Patient page
And User clicks edit icon for a particular patient
And User is on Edit Patient dialog box
When User clicks submit after editing first name with spl charc data 
Then User should  see error message in Patient name accepts only alphabets

#Skipped 10 TCs

Scenario:Edit CTC number with valid data
Given : User is on My Patient page
And User clicks edit icon for a particular patient
And User is on Edit Patient dialog box
When User clicks submit after editing the CTC number with valid data
Then User should be redirected to My Patient page with the edited value in the CTC number field

Scenario:Edit CTC number with alphabets
Given : User is on My Patient page
And User clicks edit icon for a particular patient
And User is on Edit Patient dialog box
When User clicks submit after editing the CTC number with alphabetic data
Then User should see the error message “CTC number accepts only numeric values”

#skipped 3 tcs

Scenario: Edit weight with valid value
Given : User is on My Patient page
And User clicks edit icon for a particular patient
And User is on Edit Patient dialog box
When User clicks submit after entering a valid value in the weight field
Then User should be redirected to the My Patient page with the updated weight value”

Scenario: Edit weight with alphabets
Given : User is on My Patient page
And User clicks edit icon for a particular patient
And User is on Edit Patient dialog box
When User clicks submit after entering with alphabets
Then User should see the error message “Please enter a valid weight”

Scenario: Edit weight with special characters
Given User is on My Patient page
And User clicks edit icon for a particular patient
And User is on Edit Patient dialog box
When User clicks submit after entering with special characters
Then User should see the error message “Please enter a valid weight”

Scenario: Selecting Invalid date
Given : User is on My Patient page
And User clicks edit icon for a particular patient
And User is on Edit Patient dialog box
When User enters invalid date (34/20/2022)
Then User should see an error message "Invalid date ,Please select valid date"

Scenario: Upload without selecting file
Given : User is on My Patient page
And User clicks edit icon for a particular patient
And User is on Edit Patient dialog box
When User clicks submit without uploading any file
Then User should see the error message “Please select a file to upload”









































