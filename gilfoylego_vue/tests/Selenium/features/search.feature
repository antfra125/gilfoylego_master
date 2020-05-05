Feature: Search function

    Background: 
    Given that im on the home page

    Scenario Outline: Search 1, Searching for hotels by hotels namns
        When and click on the serch bar and type in <hotelname>
        And enter a start date 
        And enter a end date
        And hit search
        Then my frist search result should be <hotelname>

        Examples:
            | hotelname |
            | Value 1   |
            | Value 1   |
            | Value 1   |

    Scenario Outline: Search 2, Searching for hotels location with citys
        When and clcik on the search bar and type in <city>
        And enter a start date
        And enter a end date
        And hit search
        Then my hotels should be located in that <city>

        Examples:
            | city    |
            | Malmö   |
            | Value 1 |
            | Value 1 |

    Scenario Outline: Search 3, Searching for hotels location with countries
        When and clcik on the search bar and type in <countrie>
        And enter a start date
        And enter a end date
        And hit search
        Then my hotels should be located in that <countrie>

        Examples:
            | countrie |
            | москва   |
            | Value 1  |
            | Value 1  |

Scenario: Search 4, Searching for hotels between to dates
        When and click on the search bar and type in "Spain"
        And enter a start date
        And enter a end date
        And hit search
        Then my hotels results should be between start-date and end-date
        
       