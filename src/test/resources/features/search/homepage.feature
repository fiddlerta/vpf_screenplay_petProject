Feature: homepage layout

  Background: user opens a home page
    Given Ann opens a homepage

  Scenario: validate homepage layout
    Then she is on homepage
    And she should see a homepage layout

  Scenario: interact with add banner on homepage
    When she clicks on add banner
    Then she lands on a page with title in a new tab
      | pageUrl                        | pageTitle                    |
      | toolsqa.com/selenium-training/ | Tools QA - Selenium Training |

  Scenario Outline: interact with widget cards on homepage
    When she clicks on "<cardName>" widget card
    Then she lands on "<pagePath>" page
    Examples:
      | cardName                | pagePath      |
      | Elements                | elements      |
      | Forms                   | forms         |
      | Alerts, Frame & Windows | alertsWindows |
      | Widgets                 | widgets       |
      | Interactions            | interaction   |
      | Book Store Application  | books         |

  Scenario: return to homepage by header
    When she clicks on "Elements" widget card
    And she clicks on header
    Then she is on homepage
