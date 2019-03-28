package com.veganmichiana.veganguide.repository;

import com.veganmichiana.veganguide.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
