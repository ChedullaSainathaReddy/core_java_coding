package com.wiprojava;
//.Write a program to add 8 to the number 2345 and then divide it by 3.
//Now, the modulus of the quotient is taken with 5 and then multiply the resultant value by 5. Display the final result.
public class ArithmeticCalculation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int number = 2345;
	        number = number + 8;
	        int quotient = number / 3;
	        int result = (quotient % 5) * 5;
	        System.out.println("Final Result: " + result);

	}

}
