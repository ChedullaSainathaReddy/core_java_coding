package com.example.uber_ride_consumer;

import org.springframework.kafka.annotation.KafkaListener;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RideConsumer {
	  private final ObjectMapper mapper = new ObjectMapper();
	    private final RideService rideService;

	    public RideConsumer(RideService rideService) {
	        this.rideService = rideService;
	    }

	    @KafkaListener(topics = "uber-ride-topic", groupId = "uber_ride_group")
	    public void listen(String message) {
	        try {
	            JsonNode node = mapper.readTree(message);
	            String op = node.get("operation").asText();
	            Long id = node.get("id").asLong();

	            switch (op.toUpperCase()) {
	                case "CREATE":
	                    Ride r = new Ride();
	                    r.setId(id);
	                    r.setDriverName(getText(node, "driverName"));
	                    r.setPassengerName(getText(node, "passengerName"));
	                    r.setPickupLocation(getText(node, "pickupLocation"));
	                    r.setDropLocation(getText(node, "dropLocation"));
	                    r.setFare(node.has("fare") && !node.get("fare").isNull() ? node.get("fare").asDouble() : null);
	                    rideService.save(r);
	                    break;

	                case "UPDATE":
	                    rideService.findById(id).ifPresent(existing -> {
	                        if (node.has("driverName")) existing.setDriverName(getText(node, "driverName"));
	                        if (node.has("passengerName")) existing.setPassengerName(getText(node, "passengerName"));
	                        if (node.has("pickupLocation")) existing.setPickupLocation(getText(node, "pickupLocation"));
	                        if (node.has("dropLocation")) existing.setDropLocation(getText(node, "dropLocation"));
	                        if (node.has("fare")) existing.setFare(node.get("fare").asDouble());
	                        rideService.save(existing);
	                    });
	                    break;

	                case "DELETE":
	                    rideService.deleteById(id);
	                    break;

	                default:
	                    
	            }
	        } catch (Exception e) {
	            e.printStackTrace(); 
	        }
	    }

	    private String getText(JsonNode node, String field) {
	        return node.has(field) && !node.get(field).isNull() ? node.get(field).asText() : null;
	    }

}
