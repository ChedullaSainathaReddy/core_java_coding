package com.wiprojava;

public class CalculatorClass {
	 public void add(int a, int b) {
	        System.out.println("Addition: " + (a + b));
	    }

	    public void diff(int a, int b) {
	        System.out.println("Difference: " + (a - b));
	    }

	    public void mul(int a, int b) {
	        System.out.println("Multiplication: " + (a * b));
	    }

	    public void div(int a, int b) {
	        if (b != 0) {
	            System.out.println("Division: " + ((double) a / b));
	        } else {
	            System.out.println("Division by zero not allowed.");
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculatorClass calc = new CalculatorClass();
	        calc.add(10, 5);
	        calc.diff(10, 5);
	        calc.mul(10, 5);
	        calc.div(10, 5);

	}

}
//OUTPUT:Addition: 15
//Difference: 5
//Multiplication: 50
//Division: 2.0

