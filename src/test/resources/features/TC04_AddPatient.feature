@Login
Feature: Add Patient Dialog Box - Validation

  Background: User logged into Application, clicks on New Patient
    When User clicks on New Patient in the header section

  Scenario: Title of the dialog box
    Then User should see Add Patient Details on the dialog box

#  Scenario: Presence of 9 input fields
#    Then User should see 9 input boxes in the Add Patient Details dialog box
#
#  Scenario: Presence of 3 dropdowns
#    Then User should see 3 dropdowns in the Add Patient Details dialog box
#
#  Scenario: Presence of file Upload option
#    Then User should see exactly 1 file upload option in Add Patient Details dialog box
#
#  Scenario: Presence of Submit button
#    Then User should see one Submit button
#
#  Scenario: State of Submit button
#    Then User should see one Submit button in disabled state
#
#  Scenario: Presence of Close button
#    Then User should see one Close button
#
#  Scenario: State of Close button
#    Then User should see one Close button in enabled state
#
#  Scenario: First name mandatory validation
#    Then User should see mandatory field error for First name
#
#  Scenario: Placeholder for second field - lastname
#    Then User should see mandatory field with placeholder "Last name" for last name
#
#  Scenario: Placeholder for third field - Email
#    Then User should see mandatory field with placeholder "Email" for email
#
#  Scenario: Placeholder for second field - Contact Number
#    Then User should see mandatory field with placeholder "Contact Number" for contact number
#
#  Scenario: Placeholder for dropdown - Allergies
#    Then User should see mandatory dropdown with placeholder "Allergies" for allergies
#
#  Scenario: Placeholder for dropdown - Food Preference
#    Then User should see mandatory dropdown with placeholder "Food Preference" for food preference
#
#  Scenario: Placeholder for dropdown - Cuisine Category
#    Then User should see mandatory dropdown with placeholder "Cuisine Category" for cuisine category
#
#  Scenario: Placeholder for DOB field
#    Then User should see mandatory DOB with placeholder "Date of Birth"
#
#  Scenario: Placeholder for Vitals section - Weight
#    Then User should see non-mandatory field placeholder with "Weight" for weight
#
#  Scenario: Placeholder for Vitals section - Height
#    Then User should see non-mandatory field placeholder with "Height" for height
#
#  Scenario: Placeholder for Vitals section - Temperature
#    Then User should see non-mandatory field placeholder with "Temperature" for temperature
#
#  Scenario: Placeholder for Vitals section - SP
#    Then User should see non-mandatory field placeholder with "SP" for sp
#
#  Scenario: Placeholder for Vitals section - DP
#    Then User should see non-mandatory field placeholder with "DP" for dp
#
#  Scenario: Presence of Upload Health Report
#    Then User should see text Upload Health Report
#
#  Scenario: Presence of No file Chosen when no files uploaded
#    Then User should see text No file Chosen
#
#  Scenario: Presence of scroll bar on the dialog box
#    Then User should see a scroll bar at the right side of dialog box
#
#  Scenario: Presence of dropdown values in Allergy
#    When User clicks on Allergy dropdown
#    Then Values should be present inside Allergy dropdown
#
#  Scenario: Number of values in Allergy dropdown
#    When User clicks on Allergy dropdown
#    Then Dropdown should contain 13 values
#
#  Scenario: Specific values in Allergy dropdown
#    When User clicks on Allergy dropdown
#    Then Dropdown should contain specific allergy values
#
#  Scenario: Presence of dropdown values in Food Preference
#    When User clicks on Food Preference dropdown
#    Then Values should be present inside Food preference dropdown
#
#  Scenario: Number of values in Food Preference dropdown
#    When User clicks on Food Preference dropdown
#    Then Dropdown should contain 5 values in Food Preference dropdown
#
#  Scenario: Specific values in Food Preference dropdown
#    When User clicks on Food Preference dropdown
#    Then Dropdown should contain specific Food Preference values
#
#  Scenario: Presence of dropdown values in Cuisine
#    When User clicks on Cuisine dropdown
#    Then Values should be present inside Cuisine dropdown
#
#  Scenario: Number of values in Cuisine dropdown
#    When User clicks on Cuisine dropdown
#    Then Cuisine dropdown should contain 36 values
#
#  Scenario: Specific values in Cuisine dropdown
#    When User clicks on Cuisine dropdown
#    Then Dropdown should contain specific Cuisine values
#
#  Scenario: Submit button enabled only when all required fields are filled
#    When User enters valid values in all required fields
#    Then Submit button should be enabled
#
#  Scenario: Success message validation for adding new patient with valid data
#    When User clicks Submit after entering valid data in all mandatory fields
#    Then User should see patient successfully created toast message
#
#
#  Scenario: Navigation to My Patients after adding new patient with valid data
#    When User clicks Submit after entering valid data in all mandatory fields
#    Then User is directed to My Patient Page with New Patient Details created
#
#  Scenario: Select a single value from Allergy dropdown
#    When User selects "Peanuts" from Allergy dropdown
#    Then "Peanuts" should be selected in the Allergy field
#
#  Scenario: Select multiple values from Allergy dropdown
#    When User selects "Peanuts" and "Milk" from Allergy dropdown
#    Then "Milk" should be selected in the Allergy field
#
#  Scenario: Selecting a value not present in Allergy dropdown
#    When User tries to select "Soybean" from Allergy dropdown
#    Then No selection should occur in the Allergy field
#
#
#  Scenario: Select a single value from Food Preference dropdown
#    When User selects "Vegan" from Food Preference dropdown
#    Then "Vegan" should be selected in the Food Preference field
#
#  Scenario: Select multiple values from Food Preference dropdown
#    When User selects "Vegan" and "Jain" from Food Preference dropdown
#    Then "Jain" should be selected in the Food Preference field
#
#  Scenario: Selecting a value not present in Food Preference dropdown
#    When User tries to select "Keto" from Food Preference dropdown
#    Then No selection should occur in the Food Preference field
#
#  Scenario: Select a single value from Cuisine Category dropdown
#    When User selects "Punjabi" from Cuisine Category dropdown
#    Then "Punjabi" should be selected in the Cuisine Category field
#
#  Scenario: Select multiple values from Cuisine Category dropdown
#    When User selects "Punjabi" and "Gujarati" from Cuisine Category dropdown
#    Then "Gujarati" should be selected in the Cuisine Category field
#
#  Scenario: Selecting a value not present in Cuisine Category dropdown
#    When User tries to select "Italian" from Cuisine Category dropdown
#    Then No selection should occur in the Cuisine Category field
#
#  Scenario: Selecting date for DOB field
#    When User clicks Date of Birth field
#    Then User should see calender date picker displayed with Month,Day,Year
