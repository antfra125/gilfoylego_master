package com.example.demo.rest;


import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
public class ActiveUserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/activeuser", method = RequestMethod.GET)
    public User currentUserName(Principal principal) {
        if(principal != null){
            return userRepository.findByUsername(principal.getName());
        }
        return null;
    }
}
