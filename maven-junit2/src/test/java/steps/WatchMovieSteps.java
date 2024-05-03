package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class WatchMovieSteps {
    @Given("The customer has an account on the platform")
    public void the_customer_has_an_account_on_the_platform() {
        System.out.println("The customer has an acc");
    }
    @Given("The customer is successfully logged in")
    public void the_customer_is_successfully_logged_in() {
        System.out.println("Logged in");
    }
    @When("The customer picks a movie")
    public void the_customer_picks_a_movie() {
        System.out.println("Picks a movie");
    }
    @When("clicks on it")
    public void clicks_on_it() {
        System.out.println("Clicks on it");
    }
    @Then("The movie starts playing")
    public void the_movie_starts_playing() {
        System.out.println("The movie starts playing");
    }
}
