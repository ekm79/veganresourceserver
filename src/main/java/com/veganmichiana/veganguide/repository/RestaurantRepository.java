package com.veganmichiana.veganguide.repository;

import com.veganmichiana.veganguide.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Restaurant findByRestaurantname(String name);
    List<Restaurant> findRestaurantsByLocationContains(String location);
    Restaurant findByDescriptionContains(String description);
    Restaurant findRestaurantsByAllveganTrue();
    Restaurant findRestaurantsByDescriptionIsLike(String string);
    Restaurant findRestaurantsByRestaurantnameContains(String string);


}
