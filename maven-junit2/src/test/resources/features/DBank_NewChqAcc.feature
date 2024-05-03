Feature: Opening new checking account - optimized

  Background:
    Given the user is logged in under "alana@gmail.com" email and "Alana11!" password

  Scenario: Open new chq account - Negative case - deposit amount < $25
    When the user creates a new checking account with the following info:
    | accountType       | ownershipType | accountName | initialDepositAmount |
    | Standard Checking | Joint         | Chq 101     | 20                   |
    Then a "The initial deposit ($20.00) entered does not meet the minimum amount ($25.00) required. Please enter a valid deposit amount." error message is displayed
    And a new account "Chq 101" was not created

  Scenario: Open new chq account - Reset button
    When the user creates a new checking account with the following info:
      | accountType       | ownershipType | accountName | initialDepositAmount |
      | Standard Checking | Joint         | Chq 102     | 200                  |
    And clicks on the Reset button
    Then the data from all fields is cleared
    And a new account "Chq 102" was not created

