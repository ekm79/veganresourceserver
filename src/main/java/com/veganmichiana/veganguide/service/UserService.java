package com.veganmichiana.veganguide.service;

import com.veganmichiana.veganguide.model.User;

import java.util.List;

public interface UserService  {

    User save(User user);
    List<User> findAll();
    void delete(long id);
}
