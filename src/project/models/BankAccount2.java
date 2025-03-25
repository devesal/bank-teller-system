package project.models;

import java.util.ArrayList;

public class BankAccount2 {
    private static int nextAccountNumber = 100000000;
    private int accountNo;
    private String accountName;
    private double balance;
    private String status;

    public BankAccount2() {
        this.accountNo = nextAccountNumber++;
        accountName = "";
        balance = 0.0;
        status = "Active";
    }

    public BankAccount2(int accountNo, String accountName) {
        this.accountNo = accountNo;
        this.accountName = accountName;
        balance = 0.0;
        status = "Active";
    }

    public BankAccount2(int accountNo, String accountName, String status) {
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.status = status;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void deposit(double amount) {
        this.balance = amount + balance;
        System.out.println("Money has been deposited to your account");
        System.out.println("Please check your account for safety measures");
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            this.balance = balance - amount;
            System.out.println("Money withdrawn: ₱" + amount);
        } else {
            System.out.println("❌ Insufficient balance. Transaction terminated");
        }
    }

    public double inquireBalance() {
        return balance;
    }

    public void transferMoney(int accountNumber, double amount, ArrayList<BankAccount2> bankAccounts) {
        if (amount > balance) {
            System.out.println("❌ Invalid amount. Transaction terminated");
            return;
        }

        for (BankAccount2 recipient : bankAccounts) {
            if (recipient.getAccountNo() == accountNumber) {
                balance -= amount;
                recipient.deposit(amount);
                System.out.println("Transfer successful! $" + amount + " has been sent to account #" + recipient.getAccountNo());
                return;
            }
        }
        System.out.println("❌ Account not found");
    }

    public void closeAccount(ArrayList<BankAccount2> bankAccounts) {
        if (balance > 0) {
            withdraw(balance);
        }
        else {
            System.out.println("❌ There is no balance to withdraw");
        }
        bankAccounts.remove(this);
        status = "Closed";
        System.out.println("This account has been closed");
    }

    public String displayAccountType() {
        return "Savings Account";
    }

    public String toString() {
        return accountName + "\n#" + accountNo + "\nStatus: " + status;
    }
} 