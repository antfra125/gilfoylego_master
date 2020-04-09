Feature: Loggin-feature

   As a user
   I want to be able to
   log in to my account
   on the website

    Background: 
    Given that I am on the "homepage"
    

Scenario Outline: login-1, login-3, login-5 och login-6
When I click the "login" button
And I enter a <username> in the "username" field
And I enter a <password> in the "password" field
And I click the "login" button
Then I should be <status>

Examples:
| username   | password   | status       |   
| "TobyLyon" | "12345"    | "logged in"  |
| "TobyLyon" | "123"      | "logged out" |
| "TLyon"    | "12345"    | "logged out" |
| "TLyon"    | "123"      | "logged out" |
| "Toby"     | "привет"   | "logged in"  |
| "привет"   | "Hej"      | "logged in"  |

Scenario Outline: login-2
When I click the "create account" button
And I enter a <valid username> in the "username" field
And I enter a <valid password> in the "password" field
And I click the "create account" button
Then the account should be <created>

Examples:
| valid username           | valid password     | created           |
| "toby_lyon@hotmail.com"  | "54321"          | "created"     |
| "toby_lyon@hotmail.com"  | "12345"          | "not created" |
| "TobyLyon"               | "54321"          | "not created" |

Scenario: login-4
When I click the "login" button
And I enter a valid username in the "username" field
And I enter a password in the "password" field
And I click the "login" button
When I click the "mina bokningar" button
Then I should be able to see my bookings
