package com.veganmichiana.veganguide.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long menuid;

    private String menuitemname;
    private ArrayList<String> menureviews;

    @ManyToOne
    @JoinColumn(name = "restaurantid")
    @JsonIgnoreProperties("menuitems")
    private Restaurant restaurantid;

    public MenuItem() {
    }

    public long getMenuid() {
        return menuid;
    }

    public void setMenuid(long menuid) {
        this.menuid = menuid;
    }

    public String getMenuitemname() {
        return menuitemname;
    }

    public void setMenuitemname(String menuitemname) {
        this.menuitemname = menuitemname;
    }

    public ArrayList<String> getMenureviews() {
        return menureviews;
    }

    public void setMenureviews(ArrayList<String> menureviews) {
        this.menureviews = menureviews;
    }

    public Restaurant getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(Restaurant restaurantid) {
        this.restaurantid = restaurantid;
    }
}
