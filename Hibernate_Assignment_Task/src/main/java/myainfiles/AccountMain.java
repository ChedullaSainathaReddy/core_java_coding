package myainfiles;

import java.util.List;
import java.util.Scanner;

import mydao.AccountDAO;
import mydao.TransactionDAO;
import mypojos.Transactions;

public class AccountMain {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountDAO accDao = new AccountDAO();
        TransactionDAO txnDao = new TransactionDAO();

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Account");
            System.out.println("2. Add Transaction");
            System.out.println("3. View Transactions by Account");
            System.out.println("4. Delete Account");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account holder name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    accDao.addAccount(name);
                    break;
                case 2:
                    System.out.print("Enter Account ID: ");
                    int accId = sc.nextInt();
                    System.out.print("Enter transaction type: ");
                    sc.nextLine();
                    String type = sc.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    txnDao.addTransaction(accId, type, amount);
                    break;
                case 3:
                    System.out.print("Enter Account ID: ");
                    int accIdView = sc.nextInt();
                    List<Transactions> txns = txnDao.getTransactionsByAccount(accIdView);
                    for (Transactions t : txns) {
                        System.out.println("Txn ID: " + t.getId() + ", Type: " + t.getType() + ", Amount: " + t.getAmount());
                    }
                    break;
                case 4:
                    System.out.print("Enter Account ID to delete: ");
                    int delId = sc.nextInt();
                    accDao.deleteAccount(delId);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
            }
        }
    }
}