package com.example.uber_ride_Task;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

public class RideController {
	  private final RideKafkaProducer producer;

	    public RideController(RideKafkaProducer producer) {
	        this.producer = producer;
	    }

	    @PostMapping
	    public ResponseEntity<?> createRide(@Valid @RequestBody RideMessageDto dto) throws Exception {
	        dto.setOperation("CREATE");
	        producer.send(dto);
	        return ResponseEntity.ok("Ride create event sent to Kafka");
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<?> updateRide(@PathVariable Long id, @Valid @RequestBody RideMessageDto dto) throws Exception {
	        dto.setOperation("UPDATE");
	        dto.setId(id);
	        producer.send(dto);
	        return ResponseEntity.ok("Ride update event sent to Kafka");
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> deleteRide(@PathVariable Long id) throws Exception {
	        RideMessageDto dto = new RideMessageDto();
	        dto.setOperation("DELETE");
	        dto.setId(id);
	        producer.send(dto);
	        return ResponseEntity.ok("Ride delete event sent to Kafka");
	    }

	  

}
