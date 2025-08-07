package com.example.Resilience4j.Circuit1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {
	 private final DeliveryService deliveryService;

	    public DeliveryController(DeliveryService deliveryService) {
	        this.deliveryService = deliveryService;
	    }

	    @GetMapping("/track")
	    public String trackOrder() {
	        return deliveryService.getDeliveryStatus();
	    }

}
