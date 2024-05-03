Feature: Opening new checking account

  Background:
    Given the user signs in with an existing account under "alana@gmail.com" email and "Alana11!" password
    And
    Given the user is on the dbank's login page
    And the user signs in with an existing account under "alana@gmail.com" email and "Alana11!" password
    And the user is on their bank account page
    And sees the green "Welcome Alana" message
    When the user clicks on the "Checking" tab
    And clicks on the "New Checking" button
    Then the "Create Checking" page opens

  Scenario: Opening new checking account - negative case - Not selecting the Account Type
    When the user does not select the Account Type
    And the user selects the "Joint" Account Ownership
    And enters the "Alana Expenses" Account Name
    And enters the "$700.00" Initial Deposit Amount
    And tries to submit by clicking on the "Submit" button
    Then a "Please select one of these options." message in the "Account Type" field pops-up
    When the user clicks on the "Checking" tab
    And clicks on the "View Checking" button
    Then the "View Checking Accounts" page opens
    Then a "You currently do not have accounts on record to view. Please create a new account." alert opens

  Scenario: Opening new checking account - negative case - Not selecting the Account Ownership
    When the user selects the "Standard Checking" Account Type
    And the user does not select the Account Ownership
    And enters the "Alana Expenses" Account Name
    And enters the "$700.00" Initial Deposit Amount
    And tries to submit by clicking on the "Submit" button
    Then a "Please select one of these options." message in the "Account Ownership" field pops-up
    When the user clicks on the "Checking" tab
    And clicks on the "View Checking" button
    Then the "View Checking Accounts" page opens
    Then a "You currently do not have accounts on record to view. Please create a new account." alert opens

  Scenario: Opening new checking account - negative case - Not entering the Account Name
    When the user selects the "Standard Checking" Account Type
    And the user selects the "Individual" Account Ownership
    And does not enter any Account Name
    And enters the "$700.00" Initial Deposit Amount
    And tries to submit by clicking on the "Submit" button
    Then a "Please fill out this field." message in the "Account Name" field pops-up
    When the user clicks on the "Checking" tab
    And clicks on the "View Checking" button
    Then the "View Checking Accounts" page opens
    Then a "You currently do not have accounts on record to view. Please create a new account." alert opens

  Scenario: Opening new checking account - negative case - Long Account Name
    When the user selects the "Standard Checking" Account Type
    And the user selects the "Individual" Account Ownership
    And enters an invalid Account Name with more than 256 characters
    And enters the "$700.00" Initial Deposit Amount
    And tries to submit by clicking on the "Submit" button
    Then a "Please fill out this field." message in the "Account Name" field pops-up