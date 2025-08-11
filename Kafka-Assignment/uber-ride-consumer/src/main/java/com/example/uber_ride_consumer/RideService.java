package com.example.uber_ride_consumer;

import java.util.List;
import java.util.Optional;

public class RideService {
	private final RideRepository repo;

    public RideService(RideRepository repo) { this.repo = repo; }

    public Ride save(Ride r) { return repo.save(r); }

    public void deleteById(Long id) { repo.deleteById(id); }

    public Optional<Ride> findById(Long id) { return repo.findById(id); }

    public List<Ride> findAll() { return repo.findAll(); }

}
