package com.veganmichiana.veganguide.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long storeid;

    private String storename;
    private String location;
    private String phone;
    private ArrayList<String> storereviews;

    @ManyToMany
    @JoinTable(name = "productlocation",
            joinColumns = {@JoinColumn(name = "storeid")},
            inverseJoinColumns = {@JoinColumn(name = "productid")})
    @JsonIgnoreProperties("stores")
    private Set<Product> products;

    public Store() {
    }

    public long getGroceryid() {
        return storeid;
    }

    public void setGroceryid(long storeid) {
        this.storeid = storeid;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<String> getStorereviews() {
        return storereviews;
    }

    public void setStorereviews(ArrayList<String> storereviews) {
        this.storereviews = storereviews;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
