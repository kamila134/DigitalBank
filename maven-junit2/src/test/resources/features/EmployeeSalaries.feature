Feature: Employees
  Objective: In this exercise, students will create step definitions for a scenario involving the management of employee information, where datatables are used to represent employee details.
  @Smoke
  Scenario: Manage Employee Information
    Given a list of employee details with the following information:
      | Employee ID | First Name | Last Name | Department | Position          | Salary  |
      | 101         | John       | Smith     | Sales      | Sales Associate   | $60,000 |
      | 102         | Jane       | Doe       | HR         | HR Manager        | $80,000 |
      | 103         | David      | Johnson   | IT         | Software Engineer | $90,000 |
    When the user adds a new employee with the following details:
      | Employee ID | First Name | Last Name | Department | Position          | Salary  |
      | 104         | Emily      | Davis     | Marketing  | Marketing Analyst | $55,000 |
    And the user updates the salary of an existing employee with Employee ID 101 to $65,000.
    And the user removes the employee with Employee ID 102 from the records.
    Then the user should be able to view and confirm the updated employee details:
      | employeeID | firstName | lastName | department | position          | salary  |
      | 101        | John      | Smith    | Sales      | Sales Associate   | $65,000 |
      | 103        | David     | Johnson  | IT         | Software Engineer | $90,000 |
      | 104        | Emily     | Davis    | Marketing  | Marketing Analyst | $55,000 |


  #Print all employee info that has letter 's' regardless of case in their surname
  #Print the max and min salaries, create a method to compare all from the datatable