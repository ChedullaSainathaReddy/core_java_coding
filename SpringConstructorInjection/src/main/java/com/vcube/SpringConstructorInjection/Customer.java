package com.vcube.SpringConstructorInjection;

public class Customer {
	int cid;
	String cname;
	int cage;
	public Customer() {
		System.out.println("no arg constructor !");
	}
	public Customer(int cid) {
		System.out.println("one arg constructor !");
		this.cid = cid;
	}
//	public Customer(int cid, String cname) {
//		System.out.println("two arg constructor  cid cname!");
//		this.cid = cid;
//		this.cname = cname;
//	}
	public Customer(int cid, int cage) {
		System.out.println("two arg constructor cid cage!");
		this.cid = cid;
		this.cage = cage;
	}
	public Customer(int cid, String cname, int cage) {
		super();
		System.out.println("parameterized constructor ");
		this.cid = cid;
		this.cname = cname;
		this.cage = cage;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCage() {
		return cage;
	}
	public void setCage(int cage) {
		this.cage = cage;
	}
	void show() {
		System.out.println("Customer ID : " + cid);
		System.out.println("Customer Name : " + cname);
		System.out.println("Customer Age : " + cage);
	}

	

}
