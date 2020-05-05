package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    public User findCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username);
    }

    public User registerUser(User user) {
        return myUserDetailsService.addUser(user.getUsername(), user.getPassword(), user.getEmail(), user.getPhone(), user.getFirstName(), user.getLastName(), user.getAddress());
    }
}
