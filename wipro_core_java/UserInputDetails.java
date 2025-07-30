package com.wiprojava;

import java.util.Scanner;

public class UserInputDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Roll Number: ");
        String roll = sc.nextLine();
        System.out.print("Enter Field of Interest: ");
        String interest = sc.nextLine();
        System.out.println("Hey, my name is " + name + " and my roll number is " + roll + ". My field of interest are " + interest + ".");
    }

	}


