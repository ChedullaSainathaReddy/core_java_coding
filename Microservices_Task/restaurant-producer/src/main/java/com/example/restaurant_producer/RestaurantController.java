package com.example.restaurant_producer;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @GetMapping
    public List<Restaurant> getRestaurants() {
        return List.of(
            new Restaurant(1, "Taj Palace", "Hyderabad"),
            new Restaurant(2, "Barbeque Nation", "Delhi"),
            new Restaurant(3, "Paradise", "Chennai")
        );
    }

}
