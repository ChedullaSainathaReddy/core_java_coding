package com.wiprojava;

abstract class Vehicle1 {
	 public abstract void startEngine();
	    public abstract void stopEngine();
	}

	class Car1 extends Vehicle1 {
	    public void startEngine() { System.out.println("Car engine started."); }
	    public void stopEngine() { System.out.println("Car engine stopped."); }
	}

	class Motorcycle extends Vehicle {
	    public void startEngine() { System.out.println("Motorcycle engine started."); }
	    public void stopEngine() { System.out.println("Motorcycle engine stopped."); }
	}

