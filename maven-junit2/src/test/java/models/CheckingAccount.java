package models;

public class CheckingAccount {

    private String accountType;
    private String ownershipType;
    private String accountName;
    private double initialDepositAmount;

    public CheckingAccount(String accountType, String ownershipType, String accountName, double initialDepositAmount) {
        this.accountType = accountType;
        this.ownershipType = ownershipType;
        this.accountName = accountName;
        this.initialDepositAmount = initialDepositAmount;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getOwnershipType() {
        return ownershipType;
    }

    public void setOwnershipType(String ownershipType) {
        this.ownershipType = ownershipType;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getInitialDepositAmount() {
        return initialDepositAmount;
    }

    public void setInitialDepositAmount(double initialDepositAmount) {
        this.initialDepositAmount = initialDepositAmount;
    }
}
