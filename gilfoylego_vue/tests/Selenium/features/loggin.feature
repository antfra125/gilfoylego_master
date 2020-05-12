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
        And I enter the username <username>
        And I enter the password <password>
        And I click the login button
        Then I should be logged in 

        Examples:
            | username       | password       |
            | "admin"        | "admin"        |

    
    
    Scenario Outline: fail to log in 
        When I click the account button
        And I click on loggin in the dropdown menu
        And I enter the username <username>
        And I enter the password <password>
        And I click the login button
        Then I should still be logged out

        Examples:
            | username | password |
            | "fel"  | "fel"  |