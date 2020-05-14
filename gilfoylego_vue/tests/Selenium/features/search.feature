Feature: Search function

    As i user
    I want to be able to sort
    hotels after 
    countrys, hotelnames and citys

    Background:
        Given that im on the search page


    Scenario: Search Norge
        When I search for hotels in "Norge"
        Then my frist search result should be a hotel in Norge

    Scenario: Search Sverige
        When I search for hotels in "Sverige"
        Then my frist search result should be a hotel in Sverige

    Scenario: Search Danmark
        When I search for hotels in "Danmark"
        Then my frist search result should be a hotel in Danmark



