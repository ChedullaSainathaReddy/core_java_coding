package com.wiprojava;

abstract class Person {
	public abstract void eat();

	public abstract void exercise();
}

class Athlete extends Person {
	public void eat() {
		System.out.println("Athlete eats a healthy diet.");
	}

	public void exercise() {
		System.out.println("Athlete trains daily.");
	}
}

class LazyPerson extends Person {
	public void eat() {
		System.out.println("Lazy person eats junk food.");
	}

	public void exercise() {
		System.out.println("Lazy person avoids exercising.");
	}
}
