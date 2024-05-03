package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class CarsSteps {

    @Given("a list of cars with their characteristics:")
    public void a_list_of_cars_with_their_characteristics(List<Map<String,String>> carList) {
        System.out.println("Car: " + carList.get(3).get("Car"));
        System.out.println("Manufacturer: " + carList.get(3).get("Manufacturer"));
        System.out.println("Type: " + carList.get(3).get("Type"));
        System.out.println("Fuel Type: " + carList.get(3).get("Fuel Type"));
        System.out.println("Engine Size (L): " + carList.get(3).get("Engine Size (L)"));
        System.out.println("Horsepower: " + carList.get(3).get("Horsepower"));
        System.out.println("Price ($): " + carList.get(3).get("Price ($)"));
    }
    @When("the user compares the cars based on the following characteristics:")
    public void the_user_compares_the_cars_based_on_the_following_characteristics(List<Map<String,String>> carList) {

    }
    @Then("the user should be able to make comparisons between the cars and determine which car has:")
    public void the_user_should_be_able_to_make_comparisons_between_the_cars_and_determine_which_car_has(List<Map<String,String>> carList) {

    }
}
