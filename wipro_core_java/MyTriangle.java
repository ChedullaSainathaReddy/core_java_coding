package com.wiprojava;

import java.util.Scanner;

public class MyTriangle {
	public static boolean isValid(double a, double b, double c) {
		return a + b > c && a + c > b && b + c > a;
	}

	public static double perimeter(double a, double b, double c) {
		return a + b + c;
	}

	public static double area(double a, double b, double c) {
		double s = perimeter(a, b, c) / 2;
		return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Enter side a (or -1 to exit): ");
			double a = sc.nextDouble();
			if (a == -1) {
				System.out.println("Bye~");
				break;
			}
			System.out.print("Enter side b: ");
			double b = sc.nextDouble();
			System.out.print("Enter side c: ");
			double c = sc.nextDouble();

			if (isValid(a, b, c)) {
				System.out.printf("Perimeter: %.2f\n", perimeter(a, b, c));
				System.out.printf("Area: %.2f\n", area(a, b, c));
			} else {
				System.out.println("The input is invalid.");
			}
		}
	}

}
//OUTPUT:Enter side a (or -1 to exit): 43
//Enter side b: 43
//Enter side c: 2
//Perimeter: 88.00
//Area: 42.99
//Enter side a (or -1 to exit): -1
//Bye~