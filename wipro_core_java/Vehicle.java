package com.wiprojava;

class Vehicle {
	 public void start() {
	        System.out.println("Vehicle is starting...");
	    }

	    public void stop() {
	        System.out.println("Vehicle has stopped.");
	    }
	}

	class Truck extends Vehicle {
	    public void loadGoods() {
	        System.out.println("Truck is loading goods.");
	    }
	}

	class Bus extends Vehicle {
	    public void carryPassengers() {
	        System.out.println("Bus is carrying passengers.");
	    }
	}

	class Car extends Vehicle {
	    public void playMusic() {
	        System.out.println("Car is playing music.");
	    }
	}
	



