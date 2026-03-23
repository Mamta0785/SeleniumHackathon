@loginFeature 
Feature: Login Functionality

  Background: User enters the URL of the application in the browser
    
    Scenario: Navigation bar text visibility
    Then User should see the text "Dietician Project" on the left side of navigation bar
    
    Scenario: Navigation bar icon visibility
    Then User should see the home icon on the left side of navigation bar

    Scenario: Navigation bar background colour
    Then Navigation bar background should have a blue-purple color

	Scenario: Page title visibility
	Then Heading "Dietician Application" should be visible inside the login card
    
    Scenario: label text visibility for the field
    Then User should see label with text in Login UI
        | Username   |
        | Password   |
    
    Scenario: presence of the input field
    Then input field should be visible in Login UI
        | Username   |
        | Password   |
    
    Scenario: presence of login button
	Then login button should be visible in Login UI
	Scenario: Login button color and styling
	Then Login button should be displayed with a blue-purple background and white text
	
	Scenario: Input field label alignment
    Then Username and Password labels should be left-aligned above their respective input fields
    
	Scenario: Total number of input fields
	Then User should see exactly two input field 
	
	Scenario: Login button enabled state
	Then User should see login button enabled
	 
@negativeTC_Login
	Scenario Outline: Invalid login attempts for "<testCaseType>"
	Given the user is on the login page
    When the user "<submission_method>" with "<testCaseType>"
    Then the appropriate error messages should be displayed in "<Field>"

    Examples:
      | testCaseType           | submission_method          | Field          |
      | Non Existing username  | submits the login form     | username field |
      | Special characters in username | submits the login form     | username field |
      | entering few characters in username | submits the login form     | username field |
      | wrong password         | submits the login form     | password field |
      | Special characters in password | submits the login form     | password field |
      | Null value in username | submits the login form     | username field |
      | Null value in password | submits the login form     | password field |


@positiveTC_Login
    Scenario Outline: Successful login from Excel
    Given the user "<submission_method>" with "<testCaseType>"
    Then the user should be redirected to the Dashboard Page
    Examples:
      | testCaseType | submission_method     |
      | valid credentials  | Submits the login form |
      