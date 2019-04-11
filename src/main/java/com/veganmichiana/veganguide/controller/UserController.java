package com.veganmichiana.veganguide.controller;

import com.veganmichiana.veganguide.model.User;
import com.veganmichiana.veganguide.repository.UserRepository;
import com.veganmichiana.veganguide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userRepo.save(user);
    }

//    @PostMapping("/login")
//    public User loginUser(@RequestBody User user) {
//        User newUser = userRepo.findByUsername(user.getUsername());
//        if (newUser.getPassword() == user.getPassword()) {
//
//        }
//    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable long id)
    {
        User user = userRepo.findById(id).get();
        userRepo.delete(user);
        return "success";
    }
}
