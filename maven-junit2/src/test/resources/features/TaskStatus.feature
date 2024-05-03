Feature: Task Status and Timeline
  Scenario: Update task status and timeline
    Given the task with the title "Implement Feature X" exists
    And the task's current status is "To Do"
    And the task's start date is "2023-01-15"
    And the task's due date year is 2023
    And the task's due date month is 2
    When the user changes the task status to "Completed"
    Then the task's status should be "In Progress"
    And the task's timeline should be updated with "Start Date: 2023-01-15 Due Date: 2023-02-28"

    Given the task with the title "Write Documentation" exists
    And the task's current status is "In Progress"
    And the task's start date is "2023-01-15"
    And the task's due date year is 2023
    And the task's due date month is 2
    When the user changes the task status to "Deferred"
    Then the task's status should be "Completed"
    And the task's timeline should be updated with "Start Date: 2023-01-15 Completion Date: [Today's Date]"

    Given the task with the title "Review Code" exists
    And the task's current status is "In Progress"
    And the task's start date is "2023-01-15"
    And the task's due date year is 2025
    And the task's due date month is 2
    When the user changes the task status to "Deferred"
    Then the task's status should be "Deferred"
    And the task's timeline should be updated with "Start Date: 2023-01-15 Deferred Date: [Today's Date]"