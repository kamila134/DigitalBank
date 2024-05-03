package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChemicalsSteps {
    @Given("professor prepares to mix chemicals")
    public void professor_prepares_to_mix_chemicals() {

    }
    @When("the following chemical reactions are performed:")
    public void the_following_chemical_reactions_are_performed(io.cucumber.datatable.DataTable dataTable) {
        System.out.println(dataTable.cell(2, 2));
        System.out.println(dataTable.cell(4, 1));
        System.out.println(dataTable.cell(3, 1) + " + " + dataTable.cell(2, 0));
        System.out.println(dataTable.cell(4, 2));
        System.out.println(dataTable.cell(2, 3) + " + " + dataTable.cell(3, 3));
    }
    @Then("result is obtained as the final product in each reaction")
    public void result_is_obtained_as_the_final_product_in_each_reaction() {

    }
    @Then("saved in the box to be carried out")
    public void saved_in_the_box_to_be_carried_out() {

    }
}
