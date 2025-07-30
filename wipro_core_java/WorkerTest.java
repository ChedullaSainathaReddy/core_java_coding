package com.wiprojava;

public class WorkerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 DailyWorker d1 = new DailyWorker("Ravi", 500);
	        SalariedWorker s1 = new SalariedWorker("Anjali", 300);

	        System.out.println("Daily Worker: " + d1.getName() + ", Pay for 5 days: " + d1.pay(5));
	        System.out.println("Salaried Worker: " + s1.getName() + ", Weekly Pay: " + s1.pay(50)); // 50 hours but paid for 40
	    }

	}

//OUTPUT:Daily Worker: Ravi, Pay for 5 days: 2500.0
//Salaried Worker: Anjali, Weekly Pay: 12000.0
