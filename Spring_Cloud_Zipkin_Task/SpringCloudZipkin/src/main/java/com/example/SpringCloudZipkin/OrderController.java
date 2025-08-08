package com.example.SpringCloudZipkin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    private final RestTemplate restTemplate;

    // ✅ Constructor injection (not field injection)
    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String placeOrder() {
        logger.info("Order placed. Calling Payment Service...");

        String response = restTemplate.getForObject("http://localhost:8082/payment", String.class);

        logger.info("Response from Payment Service: {}", response);

        return "Order placed successfully. " + response;
    }
}

