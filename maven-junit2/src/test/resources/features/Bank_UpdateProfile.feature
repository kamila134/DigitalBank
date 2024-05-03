Feature: updating user's account profile

  Background:
    Given the user is on the dbank's login page
    And the user signs in with an existing account under "alana@gmail.com" email and "Alana11!" password
    And the user is on their bank account page
    And sees the green "Welcome Alana" message
    When the user clicks on their Avatar button
    Then a dropdown menu opens under the Avatar

  Scenario: Successfully update user's profile
    When the user clicks on the My Profile button
    Then the user's profile page opens with the following details:
      | title | firstName | lastName | homePhone    | mobilePhone | workPhone | address  | locality    | region | postalCode | country |
      | Ms.   | Alana     | Bulu     | 123-456-6655 |             |           | 123 Lane | random city | NY     | 90338      | US      |
    When the user makes the following changes:
      | title | firstName | lastName | homePhone    | mobilePhone  | workPhone | address  | locality | region | postalCode | country |
      | Ms.   | Alana     | Bulu     | 123-456-6655 | 888-999-1324 |           | 123 Lane | New York | NY     | 90338      | US      |
    When the user clicks on the "Submit" button
    Then the green "Success" message is displayed
    And the user's profile is updated as follows:
      | title | firstName | lastName | homePhone    | mobilePhone  | workPhone | address  | locality | region | postalCode | country |
      | Ms.   | Alana     | Bulu     | 123-456-6655 | 888-999-1324 |           | 123 Lane | New York | NY     | 90338      | US      |

  Scenario: Unsuccessful profile update - blank required fields
    When the user leaves the First Name textbox blank
    And the user clicks on the "Submit" button
    Then the "Please fill out this field." alert pops up
    When the user reloads the page
    Then the new information should not be saved

    Scenario: next
    When the user enters postal code in the alphabetic format
    Then the "Error" message is displayed
    When the user enters region in the numeric format
    Then the "Error" message is displayed
    When the user enters country in the numeric format
    Then the "Error" message is displayed
  When the user selects and clicks on the "My Profile" button




      #Fill wrong format like phone or region or postal code
      #Empty required fields
      #Reset the title
      #Postal code can be only numeric, check it
      #Region can only be alphabetic, check it
      #Country can only be alphabetic, check it

      #Validate the error message is displayed after each wrong profile update operation
      #Validate that the data is NOT saved
