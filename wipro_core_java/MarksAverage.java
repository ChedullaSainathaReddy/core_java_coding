package com.wiprojava;

import java.util.Scanner;

public class MarksAverage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] marks = new int[3];
		int i = 0;

		while (i < 3) {
			System.out.print("Enter the mark (0-100) for student " + (i + 1) + ": ");
			int mark = sc.nextInt();
			if (mark >= 0 && mark <= 100) {
				marks[i] = mark;
				i++;
			} else {
				System.out.println("Invalid input, try again...");
			}
		}

		double average = (marks[0] + marks[1] + marks[2]) / 3.0;
		System.out.printf("The average is: %.2f\n", average);
		sc.close();
	}

}
//OUTPUT:Enter the mark (0-100) for student 1: 95
//Enter the mark (0-100) for student 2: 80
//Enter the mark (0-100) for student 3: 79
//The average is: 84.67

