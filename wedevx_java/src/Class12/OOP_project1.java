package Class12;

import java.util.ArrayList;
import java.util.List;

public class OOP_project1 {
    public static void main(String[] args) {
        Account acc1 = new Account("11479737", 750.0);
        Account acc2 = new Account("2234654", 1000);
        Account acc3 = new Account("33789668", 29000);
        List<Account> accList = new ArrayList<>();
        accList.add(acc2);
        accList.add(acc3);
        accList.add(acc1);

        List<Account> accList2 = new ArrayList<>();
        Account acc111 = new Account("4456765", 8765);
        Account acc222 = new Account("5578765", 6543);
        Account acc333 = new Account("6687654", 8000);
        accList2.add(acc222);
        accList2.add(acc333);
        accList2.add(acc111);

        Customer cust1 = new Customer("Kamila", accList);
        Customer cust2 = new Customer("Alex", accList2);
        List<Customer> custList = new ArrayList<>();
        custList.add(cust1);
        custList.add(cust2);

        Bank bank1 = new Bank("RBC", custList);
        //running a static details method:
        //detailsInMain(bank1);

       // System.out.println("======================================");

        //running an instance details method
        //bank1.details();

       // System.out.println("======================================");

        //running a transfer method (only allows to transfer between acc of the same customer)
        //cust1.transfer("2234654", "33789668", 3000);

       // System.out.println("======================================");

        //running a deposit method:
        acc1.deposit(400);

       System.out.println("======================================");

        //running a withdrawal method:
        acc1.withdrawal(500);
    }
    // Creating a static method to print all details of all customers
    //same but instance method is al saved in ine Bank class for comparison
    public static void detailsInMain (Bank bank) {
        System.out.println(bank.getName() + " has the following customers:");
        List<Customer> bankCustList = bank.getCustomers();
        int index = 1;
        for (Customer customer: bankCustList) {
            System.out.println((index++) + ". Account holder name: " + customer.getName());
            System.out.println("   Accounts held for " + customer.getName() + ":");
            List<Account> custAccList = customer.getAccounts();
            int i = 1;
            for (Account account: custAccList) {
                System.out.println("\t\t" + (i++) + ". Account number: " + account.getAccountNumber());
                System.out.println("\t\t" + "   Account balance: " + account.getBalance());
            }
        }
    }
}
//////////////////////////////////////////////////////////////////////////////////////
class Bank{
    private String name;
    private List<Customer> customers;

    public Bank(String name, List<Customer> customers) {
        this.name = name;
        this.customers = customers;
    }

    public String getName() {
        return name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    // Creating an instance method to print all details of all customers
    //same but static method is al saved in the Main class for comparison
    public void details () {
        System.out.println(this.getName() + " has the following customers:");
        List<Customer> bankCustList = this.getCustomers();
        int index = 1;
        for (Customer customer: bankCustList) {
            System.out.println((index++) + ". Account holder name: " + customer.getName());
            System.out.println("   Accounts held for " + customer.getName() + ":");
            List<Account> custAccList = customer.getAccounts();
            int i = 1;
            for (Account account: custAccList) {
                System.out.println("\t\t" + (i++) + ". Account number: " + account.getAccountNumber());
                System.out.println("\t\t" + "   Account balance: " + account.getBalance());
            }
        }
    }
}

class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name, List<Account> accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public String getName(){
        return name;
    }
    public List<Account> getAccounts(){
        return accounts;
    }

    //creating a "transfer" method (only allows to transfer between acc of the same customer):
    public void transfer (String sourceAccNum, String targetAccNum, double amount) {
        for (Account obj: accounts) {
            if (obj.getAccountNumber().equals(sourceAccNum)) {
                if (obj.getBalance() > amount) {
                    for (Account targetObj: accounts) {
                        if (targetObj.getAccountNumber().equals(targetAccNum)) {
                            System.out.println("Current balance in acc#" + obj.getAccountNumber() + ": " + obj.getBalance());
                            System.out.println("Current balance in acc#" + targetObj.getAccountNumber() + ": " + targetObj.getBalance());
                            targetObj.setBalance(targetObj.getBalance()+amount);
                            obj.setBalance(obj.getBalance()-amount);
                            System.out.println("\nTransfer completed\n");
                            System.out.println("Current balance in acc#" + obj.getAccountNumber() + ": " + obj.getBalance());
                            System.out.println("Current balance in acc#" + targetObj.getAccountNumber() + ": " + targetObj.getBalance());
                        }


                    }
                } else
                    System.out.println("ERROR: Account #" + sourceAccNum + " has insufficient funds to transfer $"
                    + amount + " to Account #" + targetAccNum);
            }
        }
    }


}

class Account{
    private String accountNumber;

    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount){
        System.out.println("Current balance: $" + getBalance());
        balance+=amount;
        System.out.println("\tAn amount of $" + amount + " has been deposited.\nNew balance is: $" + balance);

    }

    public void withdrawal (double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance to withdraw $" + amount);
        } else {
            System.out.println("Current balance: $" + getBalance());
            balance-=amount;
            System.out.println("\tAn amount of $" + amount + " has been withdrawn.\nNew balance is: $" + balance);
        }

    }



}


















