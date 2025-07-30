package com.wiprojava;

import java.util.Scanner;

public class RetailPrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	        double total = 0.0;
	        char choice;

	        do {
	            System.out.print("Enter product number (1, 2, or 3): ");
	            int productNo = sc.nextInt();
	            System.out.print("Enter quantity sold: ");
	            int quantity = sc.nextInt();

	            switch (productNo) {
	                case 1:
	                    total += 22.50 * quantity;
	                    break;
	                case 2:
	                    total += 44.50 * quantity;
	                    break;
	                case 3:
	                    total += 9.98 * quantity;
	                    break;
	                default:
	                    System.out.println("Invalid product number.");
	            }

	            System.out.print("Do you want to enter another product? (Y/N): ");
	            choice = sc.next().charAt(0);
	        } while (choice == 'Y' || choice == 'y');

	        System.out.printf("Total retail value: ₹%.2f%n", total);

	}

}
