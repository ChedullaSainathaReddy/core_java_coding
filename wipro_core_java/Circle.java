package com.wiprojava;

public class Circle implements Drawable, Fillable{

	@Override
	public void fillingColor() {
		// TODO Auto-generated method stub
		System.out.println("Blue outline");
		
	}

	@Override
	public void size() {
		// TODO Auto-generated method stub
		System.out.println("Thick");
		
	}

	@Override
	public void drawingColor() {
		// TODO Auto-generated method stub
		 System.out.println("Red fill");
		
	}

	@Override
	public void thickness() {
		// TODO Auto-generated method stub
		System.out.println("Radius 10");
		
	}

}
