@DashboardPage @LoginFeature
Feature: Dashboard Page Functionality
Background: User is successfully logged into the application 
    Given the user is on the dashboard page
    
    Scenario: Navigation bar links presence
    Then User should see the exact four links in the navigation bar
        | My Patients |
        | New Patient |
        | Login |
        | Logout |
        
    Scenario Outline: "<navigation link>" is clickable
    Then User should be able to click on "<navigation link>"  and navigate to the respective "<page>"
      Examples:
        | navigation link | page           |
        | My Patients     | My Patients    |
        | New Patient     | New Patient    |
        | Logout          | Login           |



  Scenario: home icon is clickable
    Then User should be able to click on home icon and navigate to the dashboard page
