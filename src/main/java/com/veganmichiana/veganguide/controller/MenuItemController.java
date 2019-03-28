package com.veganmichiana.veganguide.controller;

import com.veganmichiana.veganguide.model.MenuItem;
import com.veganmichiana.veganguide.model.Restaurant;
import com.veganmichiana.veganguide.repository.MenuRepository;
import com.veganmichiana.veganguide.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/menuitems", produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuItemController {

    @Autowired
    MenuRepository menuRepo;

    @Autowired
    RestaurantRepository restRepo;

    @GetMapping("/all")
    public List<MenuItem> getAllMenuItems() {
        return menuRepo.findAll();
    }

    @PostMapping("/add")
    public MenuItem addMenuItem(@RequestBody MenuItem menuItem) {
        return menuRepo.save(menuItem);
    }

    @PostMapping("/restaurants/{id}")
    public Restaurant addMenuItemToRestaurant(@RequestBody MenuItem menuitem, @PathVariable long id) {
        Restaurant restaurant = restRepo.findById(id).get();
        menuitem.setRestaurantid(restaurant);
        menuRepo.save(menuitem);
        return restRepo.findById(id).get();
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
}
