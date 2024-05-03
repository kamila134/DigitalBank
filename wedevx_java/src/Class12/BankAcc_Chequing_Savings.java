package Class12;

public class BankAcc_Chequing_Savings {
    public static void main(String[] args) {

    }
}

class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        System.out.println("Initial balance for "+ accountNumber + " is " + balance);
    }

    public  void deposit(double amount) {
        balance +=amount;
        System.out.println("Top up " + accountNumber + " for "+ amount + ". "+ balance + " available");
    }
    public  void withdraw (double amount) {
        if (balance > amount) {
            balance-=amount;
            System.out.println("Available balance for "+ accountNumber + " is "+ balance);
        } else System.out.println("Insufficient funds");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount{
    private  double interestRate;

    public SavingsAccount(double interestRate) {
        super("98", 0);
        this.interestRate = interestRate;
    }

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public  void calculateInterest(){
        super.deposit (super.balance *interestRate / 100);
    }
}

class CheckingAccount extends BankAccount {
    double overdraftLimit;



    public CheckingAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public  void  withdrawWithOverdraft(double amount) {
       if (amount < super.balance + overdraftLimit) {
            balance = balance+overdraftLimit - amount;
            System.out.println("balance for " + getAccountNumber() + " is " + getBalance());
        } else System.out.println("Insufficient funds");
    }
}
