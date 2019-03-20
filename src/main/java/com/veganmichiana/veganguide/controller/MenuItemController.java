package com.veganmichiana.veganguide.controller;

import com.veganmichiana.veganguide.model.MenuItem;
import com.veganmichiana.veganguide.repository.MenuRepository;
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

    @GetMapping("/all")
    public List<MenuItem> getAllMenuItems() {
        return menuRepo.findAll();
    }

    @PostMapping("/add")
    public MenuItem addMenuItem(@RequestBody MenuItem menuItem) {
        return menuRepo.save(menuItem);
    }
}
