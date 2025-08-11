package com.example.uber_ride_consumer;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class RideController {
	  private final RideService service;

	    public RideController(RideService service) { this.service = service; }

	    @GetMapping
	    public List<Ride> getAll() { return service.findAll(); }

	    @GetMapping("/{id}")
	    public ResponseEntity<Ride> getOne(@PathVariable Long id) {
	        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }
	

}
