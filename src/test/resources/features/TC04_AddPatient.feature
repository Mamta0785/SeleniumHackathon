Feature: Add Patient Dialog Box - Validation

  Background: User logged into Application, clicks on New Patient
    Given User is in Home Page
    When User clicks on New Patient in the header section

  Scenario: Title of the dialog box
    Then User should see Add Patient Details on the dialog box

  Scenario: Presence of 9 input fields
    Then User should see 9 input boxes in the Add Patient Details dialog box

  Scenario: Presence of 3 dropdowns
    Then User should see 3 dropdowns in the Add Patient Details dialog box

  Scenario: Presence of a Date Picker field
    Then User should see a date picker for DOB field with MM/DD/YYYY displayed

  Scenario: Presence of file Upload option
    Then User should see exactly 1 file upload option in Add Patient Details dialog box

  Scenario: Presence of Submit button
    Then User should see one Submit button

  Scenario: State of Submit button
    Then User should see one Submit button in disabled state

  Scenario: Presence of Close button
    Then User should see one Close button

  Scenario: State of Close button
    Then User should see one Close button in enabled state

  Scenario: First name mandatory validation
    Then User should see mandatory field error for First name

  Scenario: Placeholder for second field - lastname
    Then User should see mandatory field with placeholder "Last name" for last name

  Scenario: Placeholder for third field - Email
    Then User should see mandatory field with placeholder "Email" for email

  Scenario: Placeholder for second field - Contact Number
    Then User should see mandatory field with placeholder "Contact Number" for contact number

  Scenario: Placeholder for dropdown - Allergies
    Then User should see mandatory dropdown with placeholder "Allergies" for allergies

  Scenario: Placeholder for dropdown - Food Preference
    Then User should see mandatory dropdown with placeholder "Food Preference" for food preference

  Scenario: Placeholder for dropdown - Cuisine Category
    Then User should see mandatory dropdown with placeholder "Cuisine Category" for cuisine category

  Scenario: Placeholder for DOB field
    Then User should see mandatory DOB with placeholder "Date of Birth"

  Scenario: Placeholder for Vitals section - Weight
    Then User should see non-mandatory field placeholder with "Weight" for weight

  Scenario: Placeholder for Vitals section - Height
    Then User should see non-mandatory field placeholder with "Height" for height

  Scenario: Placeholder for Vitals section - Temperature
    Then User should see non-mandatory field placeholder with "Temperature" for temperature

  Scenario: Placeholder for Vitals section - SP
    Then User should see non-mandatory field placeholder with "SP" for sp

  Scenario: Placeholder for Vitals section - DP
    Then User should see non-mandatory field placeholder with "DP" for dp

  Scenario: Presence of Upload Health Report
    Then User should see text Upload Health Report

  Scenario: Presence of No file Chosen when no files uploaded
    Then User should see text No file Chosen

  Scenario: Presence of scroll bar on the dialog box
    Then User should see a scroll bar at the right side of dialog box

  Scenario: Presence of dropdown values in Allergy
    When User clicks on Allergy dropdown
    Then Values should be present inside Allergy dropdown

  Scenario: Number of values in Allergy dropdown
    When User clicks on Allergy dropdown
    Then Dropdown should contain 13 values

  Scenario: Specific values in Allergy dropdown
    When User clicks on Allergy dropdown
    Then Dropdown should contain specific allergy values
