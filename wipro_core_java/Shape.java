package com.wiprojava;

class Shape {
	public void area(int side) {
		System.out.println("Area of Square: " + (side * side));
	}

	public void area(int length, int breadth) {
		System.out.println("Area of Rectangle: " + (length * breadth));
	}

	// Perimeter methods
	public void perimeter(int side) {
		System.out.println("Perimeter of Square: " + (4 * side));
	}

	public void perimeter(int length, int breadth) {
		System.out.println("Perimeter of Rectangle: " + (2 * (length + breadth)));
	}

	
	
}
