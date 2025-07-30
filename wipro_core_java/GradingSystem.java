package com.wiprojava;

import java.util.Scanner;

public class GradingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	        System.out.print("Enter marks: ");
	        int marks = sc.nextInt();

	        if (marks < 25)
	            System.out.println("Grade F");
	        else if (marks <= 45)
	            System.out.println("Grade E");
	        else if (marks <= 50)
	            System.out.println("Grade D");
	        else if (marks <= 60)
	            System.out.println("Grade C");
	        else if (marks <= 80)
	            System.out.println("Grade B");
	        else
	            System.out.println("Grade A");
		

	}

}
