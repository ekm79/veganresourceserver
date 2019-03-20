package com.veganmichiana.veganguide.controller;

import com.veganmichiana.veganguide.model.Restaurant;
import com.veganmichiana.veganguide.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/restaurants", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantController {

    @Autowired
    RestaurantRepository restRepo;

    @GetMapping("/all")
    public List<Restaurant> getAllRestaurants() {
        return restRepo.findAll();
    }

    @PostMapping("/add")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restRepo.save(restaurant);
    }
}
