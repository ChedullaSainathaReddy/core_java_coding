package com.wiprojava;

public class Worker {
	  protected String name;
	    protected double salaryRate;

	    public Worker(String name, double salaryRate) {
	        this.name = name;
	        this.salaryRate = salaryRate;
	    }

	    public double pay(int hours) {
	        return 0; // base class does not implement pay
	    }

	    public String getName() {
	        return name;
	    }
	}

class DailyWorker extends Worker {
    public DailyWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }

    @Override
    public double pay(int days) {
        return days * salaryRate;
    }
}

class SalariedWorker extends Worker {
    public SalariedWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }

    @Override
    public double pay(int hours) {
        return 40 * salaryRate;
    }
}
