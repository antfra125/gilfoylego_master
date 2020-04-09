Feature: Booking

   As a user
   i want to be able to
   book rooms in various hotels
   with various add-ons

Background:
Given that I am on the "homepage"
And that I am logged in
And I have entered a searchterm in the searchfield
When I have pressed search
And I have chosen a room
And I am viewing my booking

Scenario:bok-1
When I check the "Extra säng" box
And I click "Confirm"
Then my booking should be completed with an extra bed

Scenario:bok-2
When I submit how many children there are
And I click "Confirm"
Then my completed booking will show the number of children there are

Scenario:bok-3
When I select the number of rooms that I want
And I click "Confirm"
Then my booking should be complete with the number of rooms I wanted

Scenario:bok-5
When I select the number of rooms that I want
And the number of rooms is greater than the available rooms
And I click "Confirm"
Then I should get an alert warning me about this

Scenario:bok-6
When I select the option "helpension"
And I click "Confirm"
Then my completed booking should say that I chose "helpension"

Scenario:bok-7
When I select the option "halvpension"
And I click "Confirm"
Then my completed booking should say that I chose "halvpension"

Scenario:bok-8
When I select the option "all-inclusive"
And I click "Confirm"
Then my completed booking should say that I chose "all-inclusive"