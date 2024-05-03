package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class GradesSteps {
    int grade = 0;

    @Given("the student name is {string}")
    public void the_student_name_is(String string) {
        System.out.println("The student's name is " + string);
    }
    @Given("the project mark for {string} is {int}")
    public void the_project_mark_for_is(String string, Integer int1) {
        System.out.println("The mark for " + string + " is " + int1);
        grade = int1;
    }
    @When("the system calculates the letter grade for {string} project mark")
    public void the_system_calculates_the_letter_grade_for_project_mark(String string) {
        System.out.println("Calculating the grade for " + string);
    }
    @Then("the system should display {string} grade as {string}")
    public void the_system_should_display_grade_as(String string, String string2) {
        if (grade <= 100 && grade >=90) {
            string2 = "A";
        } else if (grade <= 89 && grade >=70) {
            string2 = "B";
        } else if (grade <= 69 && grade >=50) {
            string2 = "C";
        } else if (grade <= 49 && grade >=30) {
            string2 = "D";
        } else {
            string2 = "E";
        }

        System.out.println("The grade for " + string + " is " + string2);
    }

}
