# Author Zakharov Mykola
# Date 24/06/2021

Feature: feature to test the title name

  Scenario: Check the name of title contains the "Automation" word

    Given the browser is opened
    And the google search page is opened
    When the "test automation" search word is entered
    And the enter button is clicked
    And the 7-th search result link is clicked
    Then the "Automation" word is present in the title