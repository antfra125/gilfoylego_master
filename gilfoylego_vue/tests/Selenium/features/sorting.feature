Feature: Sorting function

    Background: 
    Given that im on the home page
    When and i clcikt on the serchbar 
    And typted in "Sweden"
    And enterd a start-date 
    And a end-date
    And click search
    Then i should be at the result page

    Scenario: Sorting 1, Sorting the hotel results by cheapest to most expensive prices
        When i click sortresults 
        And click sort lowes to highest
        Then the results should be sorted by lowest to highest prices

    Scenario: Sorting 2, Sorting the hotel results by most expensive prices to cheapest
        When i click sortresults
        And click sort lowes to highest
        Then the results should be sorted by highest to lowest prices

    Scenario: Sorting 3, Sorting the hotel results by best to worst rating
        When i click sortresults
        And click sort best to worst rating 
        Then the results should be sorted by best to worst rating

    Scenario: Sorting 4, Sorting the hotel results by worst to best rating
        When i click sortresults
        And click sort worst to best rating
        Then the results should be sorted by worst to best rating

    Scenario: Sorting 5, Sorting the hotel results by furthes to closest to a beatch
        When i click sortresults
        And click sort worst to best rating
        Then the results should be sorted by furthes to closest to a beatch

    Scenario: Sorting 6, Sorting the hotel results by closest to furthes away to a beatch
        When i click sortresults
        And click sort worst to best rating
        Then the results should be sorted by closest to furthes away to a beatch

    Scenario: Sorting 7, Sorting the hotel results by closest to furthes away to centrum
        When i click sortresults
        And click sort worst to best rating
        Then the results should be sorted by closest to furthes away to centrum

    Scenario: Sorting 8, Sorting the hotel results by closest to furthes away to centrum
        When i click sortresults
        And click sort worst to best rating
        Then the results should be sorted by closest to furthes away to centrum




        