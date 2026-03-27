@Login
Feature:Edit Patient Dialog Box Validation

  Background: User is successfully logged into the application
    Given User is on the My Patient page after login with existing patients
    When User clicks edit icon for the particular patient

  Scenario: Title of the dialoge box
    Then User should see  Edit Patient page on the dialog box

  Scenario: Presence of Submit button
    Then User should see  submit button

  Scenario: State of submit button
    Then User should see submit button in enable mode

  Scenario: Presence of Close button
    Then  User should see  Close button

  Scenario: State of Close button
    Then  User should see close button in enable mode

Scenario: Presence of 9 Input field 
Then User should see 9 input field

Scenario: Presence of 3 drop down
Then User should see 3 drop down

Scenario:Presence of file upload option
Then User should see exactly 1 file upload option

Scenario:Presence of place holder in First Name 
Given User is edit dialog box
When User clears existing value in First Name field 
Then User should see placeholder "First Name" for FirstName

Scenario: Presence of first name of the patient
Then User should see the "First Name" field populated with the value entered during patient creation for first name.

Scenario: Presence of last name of the patient
Then User should see the "Last Name" field populated with the value entered during patient creation for last name.

Scenario:Presence of place holder in Last Name 
Then User should see placeholder "Last Name" for LastName










































