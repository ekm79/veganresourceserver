package com.veganmichiana.veganguide.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long restaurantid;

    private String restaurantname;
    private String description;
    private String location;
    private String phone;
    private Boolean allvegan;
    private String link;
    private ArrayList<String> restaurantreviews;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurantid")
    @JsonIgnoreProperties("restaurantid")
    private Set<MenuItem> menuitems;

    public Restaurant() {
    }

    public long getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(long restaurantid) {
        this.restaurantid = restaurantid;
    }

    public String getRestaurantname() {
        return restaurantname;
    }

    public void setRestaurantname(String restaurantname) {
        this.restaurantname = restaurantname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Boolean getAllvegan() {
        return allvegan;
    }

    public void setAllvegan(Boolean allvegan) {
        this.allvegan = allvegan;
    }

    public ArrayList<String> getRestaurantreviews() {
        return restaurantreviews;
    }

    public void setRestaurantreviews(ArrayList<String> restaurantreviews) {
        this.restaurantreviews = restaurantreviews;
    }

    public Set<MenuItem> getMenuitems() {
        return menuitems;
    }

    public void setMenuitems(Set<MenuItem> menuitems) {
        this.menuitems = menuitems;
    }
}
