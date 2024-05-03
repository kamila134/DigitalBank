package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Company;

import java.util.List;
import java.util.Map;

public class companyTradingSteps {

    @Given("there are <total_companies> US trading companies in the market")
    public void there_are_total_companies_us_trading_companies_in_the_market() {
        System.out.println("there are <total_companies> US trading companies in the market");
    }
    @Given("the company \"{string}\" is headquartered in \"{string}\"")
    public void the_company_company_a_is_headquartered_in_new_york(String str1, String str2) {
        System.out.println("the company " + str1 + " is hq in " + str2);
    }
    @Given("the company manages assets worth ${int} billion")
    public void the_company_manages_assets_worth_$_billion(Integer int1) {
        System.out.println("assets are worth $" + int1);
    }
    @Given("the company holds shares in {int} top companies")
    public void the_company_holds_shares_in_top_companies(Integer int1) {
        System.out.println("holds shs in " + int1 + " companies");
    }
    @Given("there are {int} employees working at the company")
    public void there_are_employees_working_at_the_company(Integer int1) {
        System.out.println("employee #: " + int1);
    }
    @Given("the company is represented by \"{string}\"")
    public void the_company_is_represented_by_john_smith(String str) {
        System.out.println("the company is represented in " + str);
    }
    @Given("the company was established in {int}")
    public void the_company_was_established_in(Integer int1) {
        System.out.println("est in " + int1);
    }
    @When("I analyze the assets, shares, employees, headquarters, representatives, and establishment year of \"{string}\"")
    public void i_analyze_the_assets_shares_employees_headquarters_representatives_and_establishment_year_of_company_a(String str) {
        System.out.println("details of " + str);
    }
    @Then("I should see the following data for \"{string}\":")
    public void i_should_see_the_following_data_for_company_a(String string, List<Company> companies) {
        System.out.println("the following of " + string + ":");
        for (Company company: companies) {
            System.out.println(company.getData() + ": " + company.getValue());
        }

    }
    @Then("I calculate the total value of shares held by \"{string}\"")
    public void i_calculate_the_total_value_of_shares_held_by_company_a(String str) {

    }
    @Then("I identify the highest-paid employee at \"{string}\"")
    public void i_identify_the_highest_paid_employee_at_company_a(String str) {

    }
    @Then("I check the total assets managed by \"{string}\"")
    public void i_check_the_total_assets_managed_by_company_a(String string) {

    }
    @Then("I verify the number of top shares held by \"{string}\"")
    public void i_verify_the_number_of_top_shares_held_by_company_a(String string) {

    }
    @Then("I determine the number of employees at \"{string}\"")
    public void i_determine_the_number_of_employees_at_company_a(String string) {

    }
    @Then("I look into the headquarters of \"{string}\"")
    public void i_look_into_the_headquarters_of_company_a(String string) {

    }
    @Then("I find the representative's name at \"{string}\"")
    public void i_find_the_representative_s_name_at_company_a(String string) {

    }
    @Then("I estimate the year of establishment of \"{string}\"")
    public void i_estimate_the_year_of_establishment_of_company_a(String string) {

    }
    @Then("I should see the additional data for \"{string}\":")
    public void i_should_see_the_additional_data_for_company_a(String str, io.cucumber.datatable.DataTable dataTable) {
        for (int i = 0; i < 8; i++) {
            System.out.println(dataTable.cell(i,0) + ": " + dataTable.cell(i,1));
        }

    }

}
