package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

//        Item B and it's price - (2,0)(2,1)
//        Item C (4,0)
//        $10.00 (2,1)
//        $25.00 and Account B (3,1) (3,0)
//        Account C (4,0)

public class WalletSteps {
    @Given("a user navigates to the wallet page")
    public void a_user_navigates_to_the_wallet_page() {

    }
    @When("the user makes the following purchases:")
    public void the_user_makes_the_following_purchases(DataTable dataTable) {
        System.out.println(dataTable.cell(3, 0 ) + " " + dataTable.cell(3,1));
        System.out.println(dataTable.cell(4, 0 ));
        System.out.println(dataTable.cell(2, 1 ));
    }
    @When("there is insufficient funds in the wallet to complete the purchases")
    public void there_is_insufficient_funds_in_the_wallet_to_complete_the_purchases() {

    }
    @Then("the user should see an {string} error message")
    public void the_user_should_see_an_error_message(String string) {

    }
    @When("the user tops up the wallet balance with the following amounts:")
    public void the_user_tops_up_the_wallet_balance_with_the_following_amounts(DataTable dataTable) {
        System.out.println(dataTable.cell(3, 1 ) + " " + dataTable.cell(3,0));
        System.out.println(dataTable.cell(4, 0 ));
    }
    @When("the user tries to make the purchases again")
    public void the_user_tries_to_make_the_purchases_again() {

    }
    @Then("the user should see a confirmation message for the successful purchases")
    public void the_user_should_see_a_confirmation_message_for_the_successful_purchases() {

    }
}
