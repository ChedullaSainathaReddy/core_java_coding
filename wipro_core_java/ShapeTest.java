package com.wiprojava;

public class ShapeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape s = new Shape();
		s.area(5); // Square
		s.area(4, 6); // Rectangle
		s.perimeter(5); // Square
		s.perimeter(4, 6); // Rectangle

	}

}
//OUTPUT:Area of Square: 25
//Area of Rectangle: 24
//Perimeter of Square: 20
//Perimeter of Rectangle: 20
