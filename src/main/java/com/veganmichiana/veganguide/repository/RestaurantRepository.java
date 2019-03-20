package com.veganmichiana.veganguide.repository;

import com.veganmichiana.veganguide.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Restaurant findByRestaurantname(String name);
    Restaurant findByLocationIsLike(String location);
    Restaurant findByDescriptionContains(String description);
    Restaurant findRestaurantsByAllveganTrue();
    Restaurant findRestaurantsByDescriptionIsLike(String string);
    Restaurant findRestaurantsByRestaurantnameContains(String string);
}
