package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Email;
import models.Employee;

import java.util.List;

//  #Print all employee info that has letter 's' regardless of case in their surname
//  #Print the max and min salaries, create a method to compare all from the datatable

public class EmployeeSalariesSteps {

    @Given("a list of employee details with the following information:")
    public void a_list_of_employee_details_with_the_following_information(io.cucumber.datatable.DataTable dataTable) {

    }
    @When("the user adds a new employee with the following details:")
    public void the_user_adds_a_new_employee_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {

    }
    @When("the user updates the salary of an existing employee with Employee ID {int} to ${double}.")
    public void the_user_updates_the_salary_of_an_existing_employee_with_employee_id_to_$(Integer int1, Double double1) {

    }
    @When("the user removes the employee with Employee ID {int} from the records.")
    public void the_user_removes_the_employee_with_employee_id_from_the_records(Integer int1) {

    }
    @Then("the user should be able to view and confirm the updated employee details:")
    public void the_user_should_be_able_to_view_and_confirm_the_updated_employee_details(List<Employee> employees) {
        int salaryMax = 0;
        int salaryMin = 1000000;
        for (Employee emp: employees) {
            if (emp.getLastName().contains("s") || emp.getLastName().contains("S")) {
                System.out.println("Employee ID: " + emp.getEmployeeID());
                System.out.println("First Name: " + emp.getFirstName());
                System.out.println("Last Name:: " + emp.getLastName());
                System.out.println("Department: " + emp.getDepartment());
                System.out.println("Position: " + emp.getPosition());
                System.out.println("Salary: $" + emp.getSalary());
                System.out.println();
            } if (emp.getSalary() > salaryMax) {
                salaryMax = emp.getSalary();
            } if (emp.getSalary() < salaryMin) {
                salaryMin = emp.getSalary();
            }

        } System.out.println("Highest salary: $" + salaryMax);
        System.out.println("Lowest salary: $" + salaryMin);

    }
}
