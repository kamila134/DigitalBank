package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ShoppingWebisteSteps {

    @Given("the customer is on the shopping website")
    public void the_customer_is_on_the_shopping_website() {

    }
    @Given("the customer is logged in")
    public void the_customer_is_logged_in() {

    }
    @Given("the customer puts the item {string} into the cart with quantity {int}")
    public void the_customer_puts_the_item_into_the_cart_with_quantity(String string, Integer int1) {

    }
    @When("the customer proceeds to checkout with shipping to {string}")
    public void the_customer_proceeds_to_checkout_with_shipping_to(String string) {

    }
    @When("the customer enters shipping information")
    public void the_customer_enters_shipping_information() {

    }
    @When("the customer makes a payment with a total price of ${double}")
    public void the_customer_makes_a_payment_with_a_total_price_of_$(Double double1) {

    }
    @Then("the customer receives an order confirmation for shipping")
    public void the_customer_receives_an_order_confirmation_for_shipping() {

    }

    @When("the customer proceeds to checkout with pickup at {string}")
    public void the_customer_proceeds_to_checkout_with_pickup_at(String string) {

    }
    @Then("the customer receives an order confirmation for pickup")
    public void the_customer_receives_an_order_confirmation_for_pickup() {

    }

    @When("the customer proceeds to checkout with no payment card")
    public void the_customer_proceeds_to_checkout_with_no_payment_card() {

    }
    @Then("the customer receives an error message about the missing payment card")
    public void the_customer_receives_an_error_message_about_the_missing_payment_card() {

    }
    @Then("the customer receives an error message about an out-of-stock item")
    public void the_customer_receives_an_error_message_about_an_out_of_stock_item() {

    }

    @Then("the customer receives an error message about the item being unavailable in this town")
    public void the_customer_receives_an_error_message_about_the_item_being_unavailable_in_this_town() {

    }
}
