package com.example.Resilience4j.Circuit1;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class DeliveryService {
	  private final RestTemplate restTemplate = new RestTemplate();

	    @CircuitBreaker(name = "deliveryStatusCB", fallbackMethod = "fallbackDeliveryStatus")
	    public String getDeliveryStatus() {
	        return restTemplate.getForObject("http://localhost:8081/delivery/status", String.class);
	    }

	    public String fallbackDeliveryStatus(Throwable t) {
	        return "Delivery status temporarily unavailable";
	    }

}
