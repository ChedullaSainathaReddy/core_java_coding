package com.example.uber_ride_consumer;

import jakarta.persistence.Id;

public class Ride {
	   @Id
	    private Long id;

	    private String driverName;
	    private String passengerName;
	    private String pickupLocation;
	    private String dropLocation;
	    private Double fare;

	    public Ride() {
	        
	    }

	    public Ride(Long id, String driverName, String passengerName, String pickupLocation, String dropLocation, Double fare) {
	        this.id = id;
	        this.driverName = driverName;
	        this.passengerName = passengerName;
	        this.pickupLocation = pickupLocation;
	        this.dropLocation = dropLocation;
	        this.fare = fare;
	    }

	    
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getDriverName() { return driverName; }
	    public void setDriverName(String driverName) { this.driverName = driverName; }

	    public String getPassengerName() { return passengerName; }
	    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }

	    public String getPickupLocation() { return pickupLocation; }
	    public void setPickupLocation(String pickupLocation) { this.pickupLocation = pickupLocation; }

	    public String getDropLocation() { return dropLocation; }
	    public void setDropLocation(String dropLocation) { this.dropLocation = dropLocation; }

	    public Double getFare() { return fare; }
	    public void setFare(Double fare) { this.fare = fare; }
	}


