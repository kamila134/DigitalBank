Feature: Email Automation
  Scenario: Configure Email Automation
    Given a list of email types with the following details:
      | Email Type         | Description                      |
      | Welcome Email      | Sent to new users                |
      | Promo Email        | Contains special offers          |
      | Notification Email | Delivers important notifications |
    When the user configures email automation settings by specifying the email type and associated automation settings:
      | emailType          | scheduleFrequency | sendTime |
      | Welcome Email      | Daily             | 09:00 AM |
      | Promo Email        | Weekly            | 02:30 PM |
      | Notification Email | Monthly           | 04:45 PM |
    And the user sets up additional email automation settings for the same email types:
      | emailType          | scheduleFrequency | sendTime |
      | Welcome Email      | Daily             | 08:30 AM |
      | Promo Email        | Weekly            | 03:00 PM |
      | Notification Email | Monthly           | 05:15 PM |
    Then the user should be able to view and confirm the configured email automation settings:
      | emailType          | scheduleFrequency | sendTime |
      | Welcome Email      | Daily             | 08:30 AM |
      | Promo Email        | Weekly            | 03:00 PM |
      | Notification Email | Monthly           | 05:15 PM |
    And the user should verify that the latest settings have been applied successfully.

  #Print all the schedules ordered from earliest to latest
  #Print all weekly email types