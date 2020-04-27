package com.example.demo.rest;

import com.example.demo.repository.HotelViewRepository;
import com.example.demo.entity.HotelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotelview")
public class HotelViewController {

    @Autowired
    private HotelViewRepository hotelViewRepository;

    @GetMapping
    public Iterable<HotelView> findAll(){return hotelViewRepository.findAll();}

}
