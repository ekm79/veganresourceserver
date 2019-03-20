package com.veganmichiana.veganguide.controller;

import com.veganmichiana.veganguide.model.Product;
import com.veganmichiana.veganguide.model.Restaurant;
import com.veganmichiana.veganguide.model.Store;
import com.veganmichiana.veganguide.repository.MenuRepository;
import com.veganmichiana.veganguide.repository.ProductRepository;
import com.veganmichiana.veganguide.repository.RestaurantRepository;
import com.veganmichiana.veganguide.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
public class SearchController {

    @Autowired
    MenuRepository menuRepo;

    @Autowired
    RestaurantRepository restRepo;

    @Autowired
    ProductRepository productRepo;

    @Autowired
    StoreRepository storeRepo;

    @GetMapping("/restaurants/{searchterm}")
    public List<Restaurant> returnRestaurants(@PathVariable String searchterm) {
        ArrayList<Restaurant> foundRestaurants = new ArrayList<>();
        if (restRepo.findRestaurantsByDescriptionIsLike(searchterm)!= null) {
            foundRestaurants.add(restRepo.findRestaurantsByDescriptionIsLike(searchterm));
        }
        if (restRepo.findRestaurantsByRestaurantnameContains(searchterm) != null) {
            foundRestaurants.add(restRepo.findRestaurantsByRestaurantnameContains(searchterm));
        } else {
            return null;
        }
        return foundRestaurants;
    }

    @GetMapping("/products/{searchterm}")
    public List<Product> findProducts(@PathVariable String searchterm) {
        ArrayList<Product> products = new ArrayList<>();
        Product foundProduct = productRepo.findProductsByProductnameContains(searchterm);
        if (foundProduct != null) {
            products.add(productRepo.findProductsByProductnameContains(searchterm));
        } else {
            return null;
        } return products;
    }
}
