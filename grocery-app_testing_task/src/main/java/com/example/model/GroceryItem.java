package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class GroceryItem {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "Name is mandatory")
	    private String name;

	    @Min(value = 1, message = "Quantity must be at least 1")
	    private int quantity;

	    // Constructors
	    public GroceryItem() {
	    }

	    public GroceryItem(Long id, String name, int quantity) {
	        this.id = id;
	        this.name = name;
	        this.quantity = quantity;
	    }

	    // Getters and Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

	    // Optional: toString method
	    @Override
	    public String toString() {
	        return "GroceryItem{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", quantity=" + quantity +
	                '}';
	    }

}
