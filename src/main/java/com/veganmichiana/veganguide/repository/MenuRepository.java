package com.veganmichiana.veganguide.repository;

import com.veganmichiana.veganguide.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface MenuRepository extends JpaRepository<MenuItem, Long> {

}
