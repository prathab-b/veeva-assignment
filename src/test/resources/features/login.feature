Feature: Login Page Functionality

    Scenario: Positive login with valid credentials
        Given User opens the login page
        When User enters the username "student"
        And User enters the password "Password123"
        And User clicks the submit button
        Then User should be redirected to the page containing "logged-in-successfully"
        And User should see "Congratulations"
        And User should see the Log out button
    
    Scenario: Negative login with invalid username
        Given User opens the login page
        When User enters the username "incorrectUser"
        And User enters the password "Password123"
        And User clicks the submit button
        Then User should see the error message with text "Your username is invalid!"
    
    Scenario: Negative login with invalid password
        Given User opens the login page
        When User enters the username "student"
        And User enters the password "incorrectPassword"
        And User clicks the submit button
        Then User should see the error message with text "Your password is invalid!"