package com.veganmichiana.veganguide.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productid;

    private String productname;
    private ArrayList<String> productreviews;

    @ManyToMany(mappedBy = "products")
    @JsonIgnoreProperties("products")
    private Set<Store> stores;

    public Product() {
    }

    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public ArrayList<String> getProductreviews() {
        return productreviews;
    }

    public void setProductreviews(ArrayList<String> productreviews) {
        this.productreviews = productreviews;
    }

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }
}
