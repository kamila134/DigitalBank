package models;
        import org.junit.jupiter.api.Test;
        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.junit.jupiter.api.Assertions.assertTrue;
        import static org.junit.jupiter.api.Assertions.assertFalse;


public class BankAccountTest {

    @Test
    public void testDeposit(){
        BankAccount bankAccount = new BankAccount("1234", 1000.00);
        bankAccount.deposit(500.00);
        assertEquals(1500.00, bankAccount.getBalance(), "deposit functionality bug");

    }

    // withdraw method test

    @Test
    public void testWithdrawSufficientFund(){
        BankAccount bankAccount = new BankAccount("1234", 1000.00);
        boolean actualResult = bankAccount.withdraw(500.00);

        assertTrue(actualResult, "withdraw did not return true");
        assertEquals(500.00, bankAccount.getBalance(), "withdraw balance mismatch");
    }


    // test withdraw with insufficient balance
    @Test
    public void testWithdrawInSufficientFund(){
        BankAccount bankAccount = new BankAccount("1234", 100.00);
        boolean actualResult = bankAccount.withdraw(200.00);

        assertFalse(actualResult, "withdraw with insufficient did not return true");
        assertEquals(100.00, bankAccount.getBalance(), "withdraw balance mismatch");
    }
}
