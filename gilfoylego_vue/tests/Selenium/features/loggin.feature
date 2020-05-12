Feature: Loggin-feature

   As a user
   I want to be able to
   log in to my account
   on the website

    Background: 
    Given that I am on the homepage
    

    Scenario Outline: login-1, login-3, login-5 och login-6
        When I click the account button 
        And I click on loggin in the dropdown menu
        And I click on the username field
        And I enter the username <username>  
        And I click on the password field
        And I enter the password <password>
        And I click the "login" button
        Then I should be <status>

        Examples:
            | username       | password       | status       |
            | "admin"        | "admin"        | "logged in"  |