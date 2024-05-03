package services;

        import models.BankAccount;
        import models.Customer;
        import org.junit.jupiter.api.Test;
        import static org.junit.jupiter.api.Assertions.assertEquals;

        import java.util.ArrayList;
        import java.util.List;

public class BankingServiceTest {

    @Test
    public void addNewCustomerTest(){
        // pre conditional steps
        BankingService bankingService = new BankingService();
        BankAccount bankAccount1 = new BankAccount("12345", 1000.00);
        Customer customer1 = new Customer("Elon Musk", "x1", bankAccount1);

        // action step for test
        bankingService.addCustomer(customer1);

        List<Customer> expectedListOfCustomers = new ArrayList<>();
        expectedListOfCustomers.add(customer1);

        assertEquals(expectedListOfCustomers, bankingService.getCustomerList(), "two customer lists are not equal");

    }

    @Test
    public void findCustomerTest(){
        // pre conditional steps
        BankingService bankingService = new BankingService();
        BankAccount bankAccount1 = new BankAccount("12345", 1000.00);
        Customer customer1 = new Customer("Elon Musk", "x1", bankAccount1);

        // action step for test
        bankingService.addCustomer(customer1);

        Customer actualResultCustomerObj = bankingService.findCustomer("x1");

        assertEquals(actualResultCustomerObj.getName(),"Elon Musk");

    }

    @Test
    public void findingCustomerTest(){
        BankingService bankingService = new BankingService();
        BankAccount ba = new BankAccount("12345", 1000.0);
        Customer customer = new Customer("Elon Musk", "x1", ba);
        bankingService.addCustomer(customer);
        Customer actual = bankingService.findCustomer("x1");
        assertEquals("Elon Musk", actual.getName(), "Name doesn't match");
        assertEquals("x1", actual.getCustomerId(), "ID doesn't match");
    }
}