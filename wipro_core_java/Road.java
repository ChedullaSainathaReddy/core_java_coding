package com.wiprojava;

public class Road {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Truck truck = new Truck();
	        Bus bus = new Bus();
	        Car car = new Car();

	        System.out.println("---- Truck ----");
	        truck.start();
	        truck.loadGoods();
	        truck.stop();

	        System.out.println("\n---- Bus ----");
	        bus.start();
	        bus.carryPassengers();
	        bus.stop();

	        System.out.println("\n---- Car ----");
	        car.start();
	        car.playMusic();
	        car.stop();
	    }
	}
//OUTPUT:---- Truck ----
//Vehicle is starting...
//Truck is loading goods.
//Vehicle has stopped.
//
//---- Bus ----
//Vehicle is starting...
//Bus is carrying passengers.
//Vehicle has stopped.
//
//---- Car ----
//Vehicle is starting...
//Car is playing music.
//Vehicle has stopped.
	



	


