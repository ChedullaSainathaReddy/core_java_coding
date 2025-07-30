package Bank;
import java.util.*;
public abstract class Account implements BankOperations {
    protected String accountNumber;
    protected double balance;
    protected List<String> transactionHistory;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    protected void addTransaction(String info) {
        transactionHistory.add(info);
    }

    public void transfer(Account target, double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            target.balance += amount;
            this.addTransaction("Transferred to Account " + target.accountNumber + ":" + amount);
            target.addTransaction("Received from Account " + this.accountNumber + ":" + amount);
        } else {
            System.out.println(" Transfer failed: Insufficient funds.");
        }
    }

    public double checkBalance() {
        return balance;
    }

    public void showTransactionHistory() {
        System.out.println("Account: " + accountNumber);
        for (String t : transactionHistory) {
            System.out.println(" - " + t);
        }
    }
}