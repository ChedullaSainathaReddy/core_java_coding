package Bank;

public class CurrentAccount extends Account {
    private final double OVERDRAFT_LIMIT = 2000.0;

    public CurrentAccount(String accNumber, double initialBalance) {
        super(accNumber, initialBalance);
    }

    public void deposit(double amount) {
        balance += amount;
        addTransaction("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if ((balance - amount) >= -OVERDRAFT_LIMIT) {
            balance -= amount;
            addTransaction("Withdrawn: " + amount);
        } else {
            System.out.println("Withdrawal failed: Overdraft limit exceeded.");
        }
    }
}