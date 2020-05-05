Feature: Filtering function

    Background:
        Given that im on the home page
        When and i clickt on the serchbar
        And typted in "Sweden"
        And enterd a start date
        And a end date
        And click search
        Then i should be at the result page


    Scenario: Filter 1, Filtering serch results with "childenterainment"
        When i click the check box for "childenterainment"
        Then the results should change to show only hotels with "childenterainment"

    Scenario: Filter 2, Filtering serch results if there is a "pool"
        When i click the check box for "pool"
        Then the results should change to show only hotels that have a "pool"

    Scenario: Filter 3, Filtering serch results with "nightenterainment"
        When i click the check box for "nightenterainment"
        Then the results should change to show only hotels that have "nightenterainment"

    Scenario: Filter 3, Filtering serch results with a "resturang"
        When i click the check box for "resturang"
        Then the results should change to show only hotels that have a "resturang"


        