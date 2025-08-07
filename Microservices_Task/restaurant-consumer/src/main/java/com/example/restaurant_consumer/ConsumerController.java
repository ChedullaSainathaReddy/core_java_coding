package com.example.restaurant_consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
	   @Autowired
	    private RestaurantClient restaurantClient;

	    @GetMapping("/restaurants")
	    public List<Restaurant> fetchRestaurants() {
	        return restaurantClient.getRestaurants();
	    }

}
