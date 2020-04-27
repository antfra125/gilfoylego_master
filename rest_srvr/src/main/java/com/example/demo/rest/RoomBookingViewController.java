package com.example.demo.rest;


import com.example.demo.entity.RoomBookingView;
import com.example.demo.repository.RoomBookingViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/roombookingview")
@RestController
public class RoomBookingViewController {
    @Autowired
    private RoomBookingViewRepository roomBookingViewRepository;

    @GetMapping
    public Iterable<RoomBookingView> findAll(){
        return roomBookingViewRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<RoomBookingView> findOneById(@PathVariable long id){
        return roomBookingViewRepository.findById(id);
    }

}
