package com.veganmichiana.veganguide.repository;

import com.veganmichiana.veganguide.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuItem, Long> {
}
