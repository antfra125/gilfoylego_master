Feature:Edit booking
    As a user 
    I want to be able
    to handle my bookings
    and create new ones

Background: 
    Given that I am logged in
    And I click the "my bookings" button
    And I click the "handle bookings" button

Scenario: edit bok-1
When I click the "cancel booking" button
Then my booking should be canceled

Scenario: edit bok-2
When I click the "edit booking" button
And I change something in my booking
And I click the "done" button
Then my booking should be edited
