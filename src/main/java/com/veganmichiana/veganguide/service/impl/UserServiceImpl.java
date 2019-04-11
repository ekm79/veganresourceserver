package com.veganmichiana.veganguide.service.impl;

import com.veganmichiana.veganguide.model.User;
import com.veganmichiana.veganguide.repository.UserRepository;
import com.veganmichiana.veganguide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService
{

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException
    {
        User user = userRepository.findByUsername(userId);
        if (user == null)
        {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthority());
    }

    public List<User> findAll()
    {
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id)
    {
        userRepository.deleteById(id);
    }

    @Override
    public User save(User user)
    {
        return userRepository.save(user);
    }

//    @Override
//    public User save() {
//        return null;
//    }
}