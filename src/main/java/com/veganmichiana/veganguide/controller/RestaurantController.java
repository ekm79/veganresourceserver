package com.veganmichiana.veganguide.controller;

import com.veganmichiana.veganguide.model.MenuItem;
import com.veganmichiana.veganguide.model.Restaurant;
import com.veganmichiana.veganguide.repository.MenuRepository;
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

    @Autowired
    MenuRepository menuRepo;

    @GetMapping("/all")
    public List<Restaurant> getAllRestaurants() {
        return restRepo.findAll();
    }


    @PostMapping("/add")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restRepo.save(restaurant);
    }

    @PutMapping("/restaurants/{id}")
    public Restaurant updateRestaurant(@RequestBody Restaurant newRestaurant, @PathVariable long id) {
        Restaurant restaurant = restRepo.findById(id).orElseThrow();
        if (restaurant != null) {
            newRestaurant.setRestaurantid(id);
            restRepo.save(newRestaurant);
            return newRestaurant;
        } else {
            return null;
        }
    }

    @DeleteMapping("/restaurants/{id}")
    public Restaurant deleteRestaurant(@PathVariable long id) {
        Restaurant restaurant = restRepo.findById(id).orElseThrow();
        if (restaurant != null) {
            restRepo.delete(restaurant);
            return restaurant;
        } else {
            return null;
        }
    }

}
