package com.wiprojava;

import java.util.Scanner;

public class AttendancemedicalCause {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	        System.out.print("Classes held: ");
	        int held = sc.nextInt();
	        System.out.print("Classes attended: ");
	        int attended = sc.nextInt();
	        sc.nextLine(); // consume newline
	        System.out.print("Do you have medical cause? (Y/N): ");
	        String cause = sc.nextLine();

	        double percentage = (attended * 100.0) / held;
	        System.out.println("Attendance: " + percentage + "%");

	        if (percentage >= 70 || cause.equalsIgnoreCase("Y"))
	            System.out.println("Allowed to sit in exam");
	        else
	            System.out.println("Not allowed to sit in exam");

	}

}
