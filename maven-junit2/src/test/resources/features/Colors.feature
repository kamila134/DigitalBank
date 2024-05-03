Feature: Color Mixing
  Scenario: Mix two colors
    Given the first color is "red"
    And the second color is "blue"
    When the system mixes the two colors
    Then the result should be "purple"
    Given the first color is "yellow"
    And the second color is "green"
    When the system mixes the two colors
    Then the result should be "yellow-green"
    Given the first color is "orange"
    And the second color is "blue"
    When the system mixes the two colors
    Then the result should be "brown"
    Given the first color is "red"
    And the second color is "green"
    When the system mixes the two colors
    Then the result should be "brown"
    Given the first color is "blue"
    And the second color is "blue"
    When the system mixes the two colors
    Then the result should be "blue"
    Given the first color is "red"
    And the second color is "yellow"
    When the system mixes the two colors
    Then the result should be "orange"
    Given the first color is "red"
    And the second color is "purple"
    When the system mixes the two colors
    Then the result should be "unknown"