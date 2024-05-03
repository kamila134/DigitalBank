package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class TransferAccOwnershipSteps {
    @Given("an account with ID {int} exists")
    public void an_account_with_id_exists(Integer int1) {
        System.out.println("Test");
    }
    @Given("the account has a current owner")
    public void the_account_has_a_current_owner() {
        System.out.println("Test");
    }
    @When("the user initiates a transfer of ownership")
    public void the_user_initiates_a_transfer_of_ownership() {
        System.out.println("Test");
    }
    @When("selects a new owner for the account")
    public void selects_a_new_owner_for_the_account() {
        System.out.println("Test");
    }
    @Then("the ownership of the account should be successfully transferred")
    public void the_ownership_of_the_account_should_be_successfully_transferred() {
        System.out.println("Test");
    }
    @Then("the new owner should receive a confirmation")
    public void the_new_owner_should_receive_a_confirmation() {
        System.out.println("Test");
    }
}
