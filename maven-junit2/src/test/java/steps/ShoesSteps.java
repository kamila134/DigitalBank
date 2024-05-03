package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Shoe;

import java.util.List;

public class ShoesSteps {

    @Given("there is a shoe order as follows:")
    public void there_is_a_shoe_order_as_follows(List<Shoe> shoes) {

    }
    @When("the user processes the shoe order, generating an invoice for the following order:")
    public void the_user_processes_the_shoe_order_generating_an_invoice_for_the_following_order(List<Shoe> shoes) {
        for (Shoe shoe: shoes) {
            System.out.println(shoe.getOrderId());
        }
    }
    @Then("the user should see the invoice generated for the order as follows:")
    public void the_user_should_see_the_invoice_generated_for_the_order_as_follows(List<Shoe> shoes) {

    }

}
