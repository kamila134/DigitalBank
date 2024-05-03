Feature: Wallet
  Scenario: Manage Wallet
    Given a user navigates to the wallet page
    When the user makes the following purchases:
    | Item   | Price  |
    |--------|--------|
    | Item A | $10.00 |
    | Item B | $15.00 |
    | Item C | $20.00 |
    And there is insufficient funds in the wallet to complete the purchases
    Then the user should see an "Insufficient Funds" error message
    When the user tops up the wallet balance with the following amounts:
    |Account  | Amount  |
    |---------|---------|
    |Account A| $50.00  |
    |Account B| $25.00  |
    |Account C| $30.00  |
    And the user tries to make the purchases again
    Then the user should see a confirmation message for the successful purchases

