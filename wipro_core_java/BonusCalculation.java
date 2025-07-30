package com.wiprojava;

import java.util.Scanner;

public class BonusCalculation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner sc = new Scanner(System.in);
	        System.out.print("Enter salary: ");
	        double salary = sc.nextDouble();
	        System.out.print("Enter years of service: ");
	        int years = sc.nextInt();

	        if (years > 6) {
	            double bonus = 0.10 * salary;
	            System.out.println("Bonus amount: " + bonus);
	        } else {
	            System.out.println("No bonus");
	        }

	}

}
