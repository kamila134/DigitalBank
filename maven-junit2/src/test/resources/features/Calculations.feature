Feature: Numeric Calculations
  @Regression
  Scenario: Perform numeric calculations
    Given the initial value is 10.5
    And another number is 5
    When the system adds the two numbers
    Then the result should be 15.5
    Given the initial value is 20
    And another number is 7
    When the system subtracts the second number from the initial value
    Then the result should be 13
    Given the initial value is 12.5
    And another number is 2
    When the system multiplies the two numbers
    Then the result should be 25.0
    Given the initial value is 18
    And another number is 3
    When the system divides the initial value by the second number
    Then the result should be 6.0
    Given the initial value is 25
    When the system calculates the square root of the initial value
    Then the result should be 5.0
    Given the initial value is 9
    When the system calculates the square of the initial value
    Then the result should be 81
    Given the initial value is 7
    When the system calculates the cube of the initial value
    Then the result should be 343
    Given the initial value is 16
    When the system calculates the square root of the initial value
    And rounds it to the nearest integer
    Then the result should be 4
    Given the initial value is 10
    And another number is 3
    When the system calculates the initial value raised to the power of the second number
    Then the result should be 1000
    Given the initial value is 2.5
    When the system calculates the initial value raised to the power of 3
    Then the result should be 15.625
    Given the initial value is 8
    And another number is 2
    When the system calculates the initial value raised to the power of the second number
    And rounds it to the nearest integer
    Then the result should be 64