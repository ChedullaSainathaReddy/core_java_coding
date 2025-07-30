package com.wiprojava;

public class BankApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank[] customers = { new Saving("S001", "Alice", 2, "Teacher", 10000, 0.05),
				new Current("C001", "Bob", 1, "Engineer", 15000, true, 0.03),
				new Current("C002", "Charlie", 1, "Doctor", 20000, false, 0.04) };

		String searchAccNo = "C001";
		boolean found = false;
		int currentCount = 0;
		double totalCurrentBalance = 0;

		for (Bank b : customers) {
			if (b instanceof Current) {
				currentCount++;
				totalCurrentBalance += b.calcBalance();
			}
			if (b.accNo.equals(searchAccNo)) {
				System.out.println("Customer Found: " + b);
				found = true;
			}
		}

		if (!found)
			System.out.println("Account not found.");
		System.out.println("Current Accounts: " + currentCount + ", Total Balance: " + totalCurrentBalance);
	}

}
//OUTPUT:Customer Found: AccNo: C001, Name: Bob, Balance: 15300.0
//Current Accounts: 2, Total Balance: 36100.0

