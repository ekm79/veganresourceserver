package com.veganmichiana.veganguide.repository;

import com.veganmichiana.veganguide.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByProductname(String name);
    List<Product> findProductsByProductnameContains(String string);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO productlocation (productid, storeid) VALUES (:productid, :storeid", nativeQuery = true)
    void addProductToStore(@Param("productid") long productid, @Param("storeid") long storeid);
}
