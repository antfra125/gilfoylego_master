Feature: Search function

    Background: 
    Given that im on the search page


    Scenario Outline: Search 1, Searching for hotels by hotels namns
        When I search for hotels in <countrys>
        Then my frist search result should be a hotel in <countrys>

        
       