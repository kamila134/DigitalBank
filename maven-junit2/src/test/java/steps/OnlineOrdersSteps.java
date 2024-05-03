package steps;

import models.OnlineOrder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import models.OnlineOrderGiven;

import java.util.List;

public class OnlineOrdersSteps {

    @Given("there is an online order with the following details:")
    public void there_is_an_online_order_with_the_following_details(List<OnlineOrderGiven> onlineOrders) {
        System.out.println("Given: ");
        for (OnlineOrderGiven onlineOrder: onlineOrders) {
            System.out.println(onlineOrder.getOrderId());
            System.out.println(onlineOrder.getCustomerName());
            System.out.println(onlineOrder.getProductName());
            System.out.println(onlineOrder.getQuantity());
            System.out.println(onlineOrder.getTotalAmount());
        } System.out.println();
    }
    @When("the user processes the online order, generating an invoice for following order:")
    public void the_user_processes_the_online_order_generating_an_invoice_for_following_order(List<OnlineOrder> onlineOrders) {
        System.out.println("When: ");
        for (OnlineOrder onlineOrder: onlineOrders) {
            System.out.println(onlineOrder.getOrderId());
            System.out.println(onlineOrder.getCustomerName());
            System.out.println(onlineOrder.getProductName());
            System.out.println(onlineOrder.getQuantity());
            System.out.println(onlineOrder.getUnitPrice());
            System.out.println(onlineOrder.getSubtotal());
            System.out.println(onlineOrder.getTaxRate());
            System.out.println(onlineOrder.getTaxAmount());
            System.out.println(onlineOrder.getTotalAmount());
        } System.out.println();


    }
    @Then("the user should see the invoice generated for the following order:")
    public void the_user_should_see_the_invoice_generated_for_the_following_order(List<OnlineOrder> onlineOrders) {
        System.out.println("Then: ");
        for (OnlineOrder onlineOrder: onlineOrders) {
            System.out.println(onlineOrder.getOrderId());
            System.out.println(onlineOrder.getCustomerName());
            System.out.println(onlineOrder.getProductName());
            System.out.println(onlineOrder.getQuantity());
            System.out.println(onlineOrder.getUnitPrice());
            System.out.println(onlineOrder.getSubtotal());
            System.out.println(onlineOrder.getTaxRate());
            System.out.println(onlineOrder.getTaxAmount());
            System.out.println(onlineOrder.getTotalAmount());
        } System.out.println();
    }
}
