package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import models.Email;

import java.util.List;

//        #Print all the schedules ordered from earliest to latest
//        #Print all weekly email types


public class EmailAutomationSteps {

    @Given("a list of email types with the following details:")
    public void a_list_of_email_types_with_the_following_details(DataTable dataTable) {

    }
    @When("the user configures email automation settings by specifying the email type and associated automation settings:")
    public void the_user_configures_email_automation_settings_by_specifying_the_email_type_and_associated_automation_settings(List<Email> emails) {
        for (Email email: emails) {
            Assertions.assertTrue(email.getSendTime().matches("\\d{2}:\\d{2} \\w{2}"));
        }
    }
    @When("the user sets up additional email automation settings for the same email types:")
    public void the_user_sets_up_additional_email_automation_settings_for_the_same_email_types(List<Email> emails) {
        for (Email email: emails) {
            Assertions.assertTrue(email.getSendTime().matches("\\d{2}:\\d{2} \\w{2}"));
        }
    }
    @Then("the user should be able to view and confirm the configured email automation settings:")
    public void the_user_should_be_able_to_view_and_confirm_the_configured_email_automation_settings(List<Email> emails) {
        int hoursEarliest = 12;
        int minutesEarliest = 0;
        int hoursLatest = 0;
        int minutesLatest = 0;
        String emailEarliest = "";
        String emailLatest = "";
        int hoursMid = 0;
        int minMid = 0;
        String emailMid = "";

        for (Email email: emails) {
            int firstDigits = Integer.parseInt(email.getSendTime().substring(0,2));
            int minutesDigits = Integer.parseInt(email.getSendTime().substring(3,5));
            if (firstDigits < hoursEarliest) {
                hoursEarliest = firstDigits;
                minutesEarliest = minutesDigits;
                emailEarliest = email.getEmailType();
            } else if (firstDigits == hoursEarliest) {
                if (minutesDigits < minutesEarliest){
                    hoursEarliest = firstDigits;
                    minutesEarliest = minutesDigits;
                    emailEarliest = email.getEmailType();
                }
            }
            if (firstDigits > hoursLatest) {
                hoursLatest = firstDigits;
                minutesLatest = minutesDigits;
                emailLatest = email.getEmailType();
            } else if (firstDigits == hoursLatest) {
                if (minutesDigits > minutesLatest){
                    hoursLatest = firstDigits;
                    minutesLatest = minutesDigits;
                    emailLatest = email.getEmailType();
                }
            } if (firstDigits != hoursEarliest && firstDigits != hoursLatest) {
                hoursMid = firstDigits;
                emailMid = email.getEmailType();
                minMid = minutesDigits;
            }
        }
        System.out.println("1. " + emailEarliest + " " + hoursEarliest + ":" + minutesEarliest);
        System.out.println("2. " + emailMid + " " + hoursMid + ":" + minMid);
        System.out.println("3. " + emailLatest + " " + hoursLatest + ":" + minutesLatest);


    }
    @Then("the user should verify that the latest settings have been applied successfully.")
    public void the_user_should_verify_that_the_latest_settings_have_been_applied_successfully() {

    }
}
