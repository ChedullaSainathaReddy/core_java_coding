package com.example.restaurant_consumer;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
@FeignClient(name = "restaurant-producer")
public interface RestaurantClient {
	 @GetMapping("/restaurants")
	    List<Restaurant> getRestaurants();

}
