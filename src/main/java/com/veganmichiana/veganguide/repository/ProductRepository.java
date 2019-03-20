package com.veganmichiana.veganguide.repository;

import com.veganmichiana.veganguide.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByProductname(String name);
    Product findProductsByProductnameContains(String string);


}
