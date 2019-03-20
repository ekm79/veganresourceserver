package com.veganmichiana.veganguide.controller;

import com.veganmichiana.veganguide.model.Product;
import com.veganmichiana.veganguide.model.Store;
import com.veganmichiana.veganguide.repository.ProductRepository;
import com.veganmichiana.veganguide.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    @Autowired
    ProductRepository productRepo;

    @Autowired
    StoreRepository storeRepo;

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @PostMapping("/add")
    public Product addProducts(@RequestBody Product product) {
        return productRepo.save(product);
    }

    @PostMapping("/stores/{id}")
    public Product addProductToStore(@RequestBody Product product, @PathVariable long storeid) {
        Store store = storeRepo.findById(storeid).get();
        Set<Store> stores = product.getStores();
        Set<Product> products = store.getProducts();
        if (!stores.contains(store)) {
            stores.add(store);
            product.setStores(stores);
//            productRepo.save(product);
        } else if (!products.contains(product)){
            products.add(product);
            store.setProducts(products);
            storeRepo.save(store);
        }

        return productRepo.save(product);
    }
}
