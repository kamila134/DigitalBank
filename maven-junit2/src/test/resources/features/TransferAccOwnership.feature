Feature: Transfer
Scenario: Account Ownership Transfer
  Given an account with ID 12345 exists
  And the account has a current owner
  When the user initiates a transfer of ownership
  And selects a new owner for the account
  Then the ownership of the account should be successfully transferred
  And the new owner should receive a confirmation