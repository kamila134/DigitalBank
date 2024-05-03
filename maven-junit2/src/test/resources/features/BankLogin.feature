Feature: Logging into a bank account

  Scenario: Successful login into a bank accountc
    Given the user is on the dbank's login pagec
    And the user has an existing account under "alana@gmail.com" email and "Alana11!" password
    When the user enters the above login credentials
    And the user checks the "Remember me" checkbox
    And the user clicks on the "Sign in" buttonc
    Then the user's account page opens
    And sees the green "Welcome Alana" messagej
    When the user clicks on the "Submit" button



