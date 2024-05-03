Feature: Watch Movie

  Scenario: The customer watches a movie on the platform
    Given The customer has an account on the platform
    And The customer is successfully logged in
    When The customer picks a movie
    And clicks on it
    Then The movie starts playing