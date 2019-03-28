package com.veganmichiana.veganguide.controller;

import com.veganmichiana.veganguide.model.Product;
import com.veganmichiana.veganguide.model.Store;
import com.veganmichiana.veganguide.repository.ProductRepository;
import com.veganmichiana.veganguide.repository.StoreRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@CrossOrigin
@Api(value = "Vegan Michiana Resource guide", description = "Guide to finding vegan-friendly restaurants and products in the Michiana area")

@RestController
@RequestMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    @Autowired
    ProductRepository productRepo;

    @Autowired
    StoreRepository storeRepo;

    @ApiOperation(value="List All Products", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to the view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")

    })
    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @PostMapping("/add")
    public Product addProducts(@RequestBody Product product) {
        return productRepo.save(product);
    }

    @PostMapping("/stores/{storeid}")
    public void addProductToStore(@RequestBody Product product, @PathVariable long storeid) {
        productRepo.addProductToStore(product.getProductid(),storeid);

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
