Feature: Coursera project

  Scenario: Retrieve course data
    Given the browser is launched and the URL is opened
    When searching for a course
    And selecting the language
    And selecting the level
    Then retrieve data for the selected courses

  Scenario: Print list of Languages and Levels
    Given obtaining the list of languages
    When Clicking on the apply button
    Then retrieve the list of levels

  Scenario: Fill the form with invalid email address
    Given navigate back to the home page
    When Clicking on For Enterprises
    And Clicking on Solutions
    And Clicking on For Campus
    And Filling out the form with an invalid email
    And Submitting the form
    Then Capture the Error Message
    Then Close the browser
