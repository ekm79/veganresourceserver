package com.veganmichiana.veganguide.controller;

import com.veganmichiana.veganguide.model.*;
import com.veganmichiana.veganguide.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {

    @Autowired
    MenuRepository menuRepo;

    @Autowired
    RestaurantRepository restRepo;

    @Autowired
    ProductRepository productRepo;

    @Autowired
    StoreRepository storeRepo;

    @Autowired
    UserRepository userRepo;

    @GetMapping("/users")
    public List<User> getAllUsers () {
        return userRepo.findAll();
    }

    @PostMapping("/menuitems")
    public MenuItem addMenuItem(@RequestBody MenuItem menuItem) {
        return menuRepo.save(menuItem);
    }

    @PostMapping("/restaurants")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restRepo.save(restaurant);
    }

    @PostMapping("/stores")
    public Store addStore(@RequestBody Store store) {
        return storeRepo.save(store);
    }

    @PostMapping("/products")
    public Product addProducts(@RequestBody Product product) {
        return productRepo.save(product);
    }

    @PutMapping("/menuitems/{id}")
    public MenuItem updateMenu(@RequestBody MenuItem newMenuItem, @PathVariable long id) {
        MenuItem menuItem = menuRepo.findById(id).orElseThrow();
        if (menuItem != null) {
            newMenuItem.setMenuid(id);
            menuRepo.save(newMenuItem);
            return newMenuItem;
        } else {
            return null;
        }
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

    @PutMapping("/stores/{id}")
    public Store updateStore(@RequestBody Store newStore, @PathVariable long id) {
        Store store = storeRepo.findById(id).orElseThrow();
        if (store != null) {
            newStore.setGroceryid(id);
            storeRepo.save(newStore);
            return newStore;
        } else {
            return null;
        }
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@RequestBody Product newProduct, @PathVariable long id) {
        Product product = productRepo.findById(id).orElseThrow();
        if (product != null) {
            newProduct.setProductid(id);
            productRepo.save(newProduct);
            return newProduct;
        } else {
            return null;
        }
    }

    @DeleteMapping("/menuitems/{id}")
    public MenuItem deleteMenuItem(@PathVariable long id) {
        MenuItem menuItem = menuRepo.findById(id).orElseThrow();
        if (menuItem != null) {
            menuRepo.delete(menuItem);
            return menuItem;
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

    @DeleteMapping("/stores/{id}")
    public Store deleteStore(@PathVariable long id) {
        Store store = storeRepo.findById(id).orElseThrow();
        if (store != null) {
            storeRepo.delete(store);
            return store;
        } else {
            return null;
        }
    }

    @DeleteMapping("/products/{id}")
    public Product deleteProduct(@PathVariable long id) {
        Product product = productRepo.findById(id).orElseThrow();
        if (product != null) {
            productRepo.delete(product);
            return product;
        } else {
            return null;
        }
    }
}
