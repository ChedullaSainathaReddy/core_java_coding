package Bank;
public class BankSystem {
    public static void main(String[] args) {
        BankBranch branch = new BankBranch("B001", "Main Branch");
        Customer c1 = new Customer("C001", "Alice");
        System.out.println(" Customer Created: " + c1.getName() + " [Customer ID: " + c1.getCustomerId() + "]");
        branch.addCustomer(c1);
        SavingsAccount savings = new SavingsAccount("S001", 5000.0);
        CurrentAccount current = new CurrentAccount("C001", 2000.0);
        System.out.println("Savings Account [S001] opened with initial balance: 5000.0");
        System.out.println("Current Account [C001] opened with initial balance: 2000.0 and overdraft limit 2000.0");
        c1.addAccount(savings);
        c1.addAccount(current);
        savings.deposit(2000.0);
        System.out.println("Deposited 2000.0 to Savings Account [S001]");
        System.out.println("Current Balance: " + savings.checkBalance());
        current.withdraw(2500.0);
        System.out.println("Withdrawn 2500.0 from Current Account [C001]");
        System.out.println("Current Balance: " + current.checkBalance());
        savings.transfer(current, 1000.0);
        System.out.println("Transferred 1000.0 from Savings to Current Account");
        System.out.println("Savings Balance: " + savings.checkBalance());
        System.out.println("Current Balance: " + current.checkBalance());
        System.out.println("\n Transaction History:");
        savings.showTransactionHistory();
        current.showTransactionHistory();
    }
}