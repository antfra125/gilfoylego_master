package com.example.demo.rest;

import com.example.demo.entity.Hotel;
import com.example.demo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/hotel") // Parent-URL:n för denna klass
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping
    public Iterable<Hotel> findAll(){
        return hotelRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Hotel> findById(long id){
        return hotelRepository.findById(id);
    }
    @GetMapping("/name/{name}")
    public Iterable<Hotel> findAllByName(String name){
        return hotelRepository.findAllByName(name);
    }
    @GetMapping("/cityId/{cityId}")
    public Iterable<Hotel> findAllByCityId(long cityId){
        return hotelRepository.findAllByCityId(cityId);
    }
    @GetMapping("/hasRestaurant")
    public Iterable<Hotel> findAllByHasRestaurant(boolean hasRestaurant){
        return hotelRepository.findAllByHasRestaurant(hasRestaurant);
    }
    @GetMapping("/hasPool")
    public Iterable<Hotel> findAllByHasPool(boolean hasPool){
        return hotelRepository.findAllByHasPool(hasPool);
    }
    @GetMapping("/hasKidsClub")
    public Iterable<Hotel> findAllByHasKidsClub(boolean hasKidsClub){
        return hotelRepository.findAllByHasKidsClub(hasKidsClub);
    }
    @GetMapping("/hasEveningEntertainment")
    public Iterable<Hotel> findAllByHasEveningEntertainment(boolean hasEveningEntertainment){
        return hotelRepository.findAllByHasEveningEntertainment(hasEveningEntertainment);
    }
    @GetMapping("/beachCloserThan/{metersToBeach}")
    public Iterable<Hotel> findAllByMetersToBeach(int metersToBeach){
        var h = hotelRepository.findAllByMetersToBeach(metersToBeach);
        return null;//TODO this
    }

}
