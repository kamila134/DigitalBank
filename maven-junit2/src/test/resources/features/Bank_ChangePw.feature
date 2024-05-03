Feature: changing user's password

  Background:
    Given the user is on the dbank's login page
    And the user signs in with an existing account under "alana@gmail.com" email and "Alana11!" password
    And the user is on their bank account page
    And sees the green "Welcome Alana" message
    When the user clicks on their Avatar button
    Then a dropdown menu opens under the Avatar
    When the user selects and clicks on the "Change Password" button
    Then the Password Management page opens
    When the user enters their current password "Alana11!"

  Scenario: Successful password update
    And the user enters the new password "Random1234!" in both fields
    And the new password "Random1234!" has at least 8 characters, 1 uppercase, 1 lowercase, and 1 digit
    And the user clicks on the Update Password button
    Then the green "Success Password Updated Successfully." message is displayed
    When the user loges out of their account
    And tries to sign in with the new password "Random1234!" under the "alana@gmail.com" email
    Then the user is on their bank account page
    And sees the green "Welcome Alana" message

  Scenario: Unsuccessful password update - Invalid password
    And the user enters the new password "123" in both fields
    And the new password "123" doesn't have at least 8 characters, 1 uppercase, 1 lowercase, or 1 digit
    And the user clicks on the Update Password button
    Then a "Password must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" pop-up is displayed
    When the user loges out of their account
    And tries to sign in with the new password "123" under the "alana@gmail.com" email
    Then an "Error Invalid credentials or access not granted due to user account status or an existing user session." error message is displayed

  Scenario: Unsuccessful password update - Password mismatch
    And the user enters a new valid password "Alana22!" in the first field
    And the user enters a different valid password "Alana22#" in the second field
    And the user clicks on the Update Password button
    Then a "Passwords Do Not Match" message is displayed
    When the user loges out of their account
    And tries to sign in with the new password "123" under the "alana@gmail.com" email
    Then an "Error Invalid credentials or access not granted due to user account status or an existing user session." error message is displayed