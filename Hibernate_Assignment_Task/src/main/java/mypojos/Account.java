package mypojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.Transaction;

//one to many bidirectional
//parent
@Entity
public class Account {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String holderName;

	    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	    private List<Transactions> transactions;

	    
	    public int getId() { 
	    	return id; 
	    	}
	    public String getHolderName() { 
	    	return holderName; 
	    	}
	    public void setHolderName(String holderName) { 
	    	this.holderName = holderName; 
	    	}
	    public List<Transactions> getTransactions() { 
	    	return transactions; 
	    	}
	    public void setTransactions(List<Transactions> transactions) { 
	    	this.transactions = transactions; 
	    	}
}
