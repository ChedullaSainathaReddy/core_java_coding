package Bank;

import java.util.*;

public class BankBranch {
    private String branchId;
    private String branchName;
    private List<Customer> customers;

    public BankBranch(String id, String name) {
        this.branchId = id;
        this.branchName = name;
        this.customers = new ArrayList<>();
        System.out.println("Branch Created: " + name + " [Branch ID: " + id + "]");
    }

    public void addCustomer(Customer c) {
        customers.add(c);
        System.out.println(" Customer added to branch.");
    }

    public Customer findCustomerById(String id) {
        for (Customer c : customers) {
            if (c.getCustomerId().equals(id)) return c;
        }
        return null;
    }

    public void listAllCustomers() {
        System.out.println(" Customers in " + branchName + ":");
        for (Customer c : customers) {
            System.out.println(" - " + c.getName() + " [ID: " + c.getCustomerId() + "]");
        }
    }
}