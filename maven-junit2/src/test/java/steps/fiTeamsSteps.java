package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class fiTeamsSteps {

    @Given("there are {int} F1 teams in the championship")
    public void there_are_f1_teams_in_the_championship(Integer int1) {
        System.out.println("There are " + int1 + " F1 teams");
    }
    @Given("the {string} team {string} is an F1 team")
    public void the_team_mercedes_is_an_f1_team(String string1, String string2) {
        System.out.println("the " + string1 + " team");
    }
    @When("I check the main representatives of the {string} {string}")
    public void i_check_the_main_representatives_of_the_mercedes_management(String string1, String string2) {
        System.out.println("When 1");
    }
    @Then("I should see their {string} is {string}")
    public void i_should_see_their_team_principal_is_toto_wolff(String string1, String string2) {
        System.out.println("Then 1");
    }
    @Then("I compare the {string} and {string} teams")
    public void i_compare_the_mercedes_and_red_bull_teams(String string1, String string2) {
        System.out.println("Then 2");
    }
    @Then("I should see the comparison results")
    public void i_should_see_the_comparison_results() {
        System.out.println("Then 3");
    }
    @Then("I explore the specifications of {string}'s F1 car")
    public void i_explore_the_specifications_of_mercedes_s_f1_car(String string) {
        System.out.println("Then 4");
    }
    @Then("I should see details about its engine, chassis, and performance")
    public void i_should_see_details_about_its_engine_chassis_and_performance() {
        System.out.println("Then 5");
    }
}
