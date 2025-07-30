package com.wiprojava;

public class Square implements Drawable, Fillable {

	@Override
	public void fillingColor() {
		// TODO Auto-generated method stub
		 System.out.println("Green border");
		
	}

	@Override
	public void size() {
		// TODO Auto-generated method stub
		System.out.println("Medium");
	}

	@Override
	public void drawingColor() {
		// TODO Auto-generated method stub
		System.out.println("Yellow fill");
	}

	@Override
	public void thickness() {
		// TODO Auto-generated method stub
		System.out.println("Side 5");
		
	}

}
