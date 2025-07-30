package com.wiprojava;

import java.util.Scanner;

public class AttendanceCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	        System.out.print("Classes held: ");
	        int held = sc.nextInt();
	        System.out.print("Classes attended: ");
	        int attended = sc.nextInt();

	        double percentage = (attended * 100.0) / held;
	        System.out.println("Attendance: " + percentage + "%");

	        if (percentage >= 70)
	            System.out.println("Allowed to sit in exam");
	        else
	            System.out.println("Not allowed to sit in exam");

	}

}
