package com.example.restaurant_consumer;

public class Restaurant {
	 private int id;
	    private String name;
	    private String location;

	    // Default constructor
	    public Restaurant() {
	    }

	    // Parameterized constructor
	    public Restaurant(int id, String name, String location) {
	        this.id = id;
	        this.name = name;
	        this.location = location;
	    }

	    // Getter and Setter for id
	    public int getId() {
	        return id;
	    }
	    public void setId(int id) {
	        this.id = id;
	    }

	    // Getter and Setter for name
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }

	    // Getter and Setter for location
	    public String getLocation() {
	        return location;
	    }
	    public void setLocation(String location) {
	        this.location = location;
	    }

	    // Optional: toString() for debugging/logging
	    @Override
	    public String toString() {
	        return "Restaurant{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", location='" + location + '\'' +
	                '}';
	    }
	

}
