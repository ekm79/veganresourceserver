package com.veganmichiana.veganguide.controller;

import com.veganmichiana.veganguide.model.Store;
import com.veganmichiana.veganguide.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/stores", produces = MediaType.APPLICATION_JSON_VALUE)
public class StoreController {

    @Autowired
    StoreRepository storeRepo;

    @GetMapping("/all")
    public List<Store> getAllProducts() {
        return storeRepo.findAll();
    }

    @PostMapping("/add")
    public Store addStore(@RequestBody Store store) {
        return storeRepo.save(store);
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
}
