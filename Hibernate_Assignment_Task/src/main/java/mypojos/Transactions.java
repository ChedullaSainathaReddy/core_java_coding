package mypojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//one to many bidirectional
//child
@Entity
public class Transactions {

	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String type;
	    private double amount;

	    @ManyToOne
	    @JoinColumn(name = "account_id")
	    private Account account;
	    
	    public int getId() { 
	    	return id; 
	    	}
	    public String getType() { 
	    	return type;
	    	}
	    public double getAmount() {
	    	return amount; 
	    	}
	    public void setType(String type) { 
	    	this.type = type; 
	    	}
	    public void setAmount(double amount) { 
	    	this.amount = amount;
	    	}
	    public Account getAccount() { 
	    	return account; 
	    	}
	    public void setAccount(Account account) {
	    	this.account = account;
	    	}
}
