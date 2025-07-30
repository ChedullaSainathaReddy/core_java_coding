package com.wiprojava;

abstract class Bank {
	String accNo;
    String custName;
    int custGender;
    String custJob;
    double curBal;

    Bank(String accNo, String custName, int custGender, String custJob, double curBal) {
        this.accNo = accNo; this.custName = custName;
        this.custGender = custGender; this.custJob = custJob;
        this.curBal = curBal;
    }

    public String toString() {
        return "AccNo: " + accNo + ", Name: " + custName + ", Balance: " + calcBalance();
    }

    public double calcBalance() {
		return 0;
	}
}

class Saving extends Bank {
    double savRate;

    Saving(String accNo, String custName, int gender, String job, double bal, double savRate) {
        super(accNo, custName, gender, job, bal);
        this.savRate = savRate;
    }

    public double calcBalance() {
        return curBal + (savRate * curBal);
    }
}

class Current extends Bank {
    boolean fixedDep;
    double curRate;

    Current(String accNo, String custName, int gender, String job, double bal, boolean fixedDep, double curRate) {
        super(accNo, custName, gender, job, bal);
        this.fixedDep = fixedDep;
        this.curRate = curRate;
    }

    public double calcBalance() {
        double balance = curBal + (curRate * curBal);
        if (fixedDep) balance -= 150;
        return balance;
    }
}


