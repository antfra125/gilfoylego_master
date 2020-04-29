package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public BCryptPasswordEncoder getEncoder() {
        return encoder;
    }

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void createDefaultUsers(){
        if (userRepository.findByUsername("admin") == null) {
            addUser("admin", "admin", "admin@admin.se", "0707000000", "Admin", "Admin", "Admingatan 99 23333 Helvetet");
        }
        if (userRepository.findByUsername("MiniHarald") == null) {
            addUser("MiniHarald", "test", "miniharald@gmail.com", "0734323237", "Alexander", "Persson", "Tågmästaregatan 8 23343 Svedala");
        }
        /*for(long i=0; i < 1000; i++) {
            String notEncodedPw = userRepository.findById(i).get().getPassword();
            String encodedPw = encoder.encode(notEncodedPw);
            userRepository.findById(i).get().setPassword(encodedPw);
        }*/
    }

    public User addUser(String username, String password, String email, String phone, String firstName, String lastName, String address){
        User user = new User(username, encoder.encode(password), email, phone, firstName, lastName, address);
        try {
            return userRepository.save(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("Användare och lösenord stämde inte överens!");
        }
        return toUserDetails(user);
    }

    private UserDetails toUserDetails(User user) {
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles("ANVÄNDARE")
                .build();
    }
}
