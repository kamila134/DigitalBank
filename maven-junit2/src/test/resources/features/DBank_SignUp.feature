Feature: Sign up function

  Background:
    Given the user is on the login page

  Scenario: Registering a new account
    When the user registers a new account as follows:
      | firstName | lastName | gender | dateOfBirth | ssn         | email              | password  | address | locality | region | postalCode | country | homePhone  |
      | Peter     | Kale     | M      | 11/05/1994  | 275-59-9034 | Peter102@gmail.com | Peter123! | Main st | LA       | CA     | 90808      | US      | 3607857533 |
    Then a new account is created

  Scenario: Updating profile
    When a user updates the profile as follows:
      | firstName | lastName | address    | locality | region | postalCode | country | homePhone  |
      | Peter     | Kale     | Gallery st | LA       | CA     | 23045      | US      | 3607857533 |
    Then the profile is updated

  Scenario: Opening a new chq account
    When a user opens a new checking account as follows:
      | accountType       | ownershipType | accountName | initialDepositAmount |
      | Interest Checking | Joint         | Third Chq   | 100                  |
    Then a new checking account "Third Chq" is created