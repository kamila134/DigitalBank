package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class TaskStatusSteps {
    private String startDate = "";
    private int dueYear = 0;
    private int dueMonth = 0;
    private String newStatus = "";

    @Given("the task with the title {string} exists")
    public void the_task_with_the_title_exists(String title) {
        // Implementation to create or retrieve the task with the given title
        System.out.println("Task created/retrieved: " + title);
    }
    @Given("the task's current status is {string}")
    public void the_task_s_current_status_is(String currentStatus) {
        System.out.println("Current status: " + currentStatus);
    }
    @Given("the task's start date is {string}")
    public void the_task_s_start_date_is(String startDate) throws RuntimeException {
        System.out.println("Start date: " + startDate);
        if (startDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
            this.startDate = startDate;
        } else {
            throw new RuntimeException("Date format should be YYYY-MM-DD");
        }
    }
    @Given("the task's due date year is {int}")
    public void the_task_s_due_date_year_is(Integer dueYear) {
        this.dueYear = dueYear;
    }

    @Given("the task's due date month is {int}")
    public void the_task_s_due_date_month_is(Integer dueMonth) {
        this.dueMonth = dueMonth;
    }

    @When("the user changes the task status to {string}")
    public void the_user_changes_the_task_status_to(String newStatus) {
        System.out.println("New status: " + newStatus);
        this.newStatus = newStatus;
    }
    @Then("the task's status should be {string}")
    public void the_task_s_status_should_be(String expectedStatus) throws Exception {
        if (expectedStatus.equals(newStatus)){
            throw new Exception("Status must be updated");
        }
        assert newStatus.equals(expectedStatus);
    }

    @Then("the task's timeline should be updated with {string}")
    public void the_task_s_timeline_should_be_updated_with(String expectedTimeline) {
        String updDate = "";
        String newDate = dueYear + "-" + dueMonth + "-" + "28";
        switch (newStatus) {
            case "In Progress":
                updDate = "Due date: ";
                break;
            case "Completed":
                updDate = "Completion Date: ";
                break;
            case "Deferred":
                updDate = "Deferred Date: ";
                newDate = "2024-02-16";
                break;
        }
        String calculatedTimeline = "Start Date: " + startDate + " " + updDate + newDate;
        assert calculatedTimeline.equals(expectedTimeline);
    }
}
