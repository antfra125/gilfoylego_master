package com.example.demo.rest;

import com.example.demo.entity.Hotel;
import com.example.demo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public Optional<Hotel> findByIdEquals(@PathVariable long id){
        System.out.println("printing LALALALALAALALLALALALA\n\nLALALALALALLAALAL\n\nHOHOHOHOHOHOHOL"); return hotelRepository.findByIdEquals(id);
    }
    @GetMapping("/name/{name}")
    public Iterable<Hotel> findAllByNameContains(@PathVariable String name){
        return hotelRepository.findAllByNameContains(name);
    }
    @GetMapping("/cityId/{cityId}")
    public Iterable<Hotel> findAllByCityIdEquals(@PathVariable long cityId){
        return hotelRepository.findAllByCityIdEquals(cityId);
    }
    @GetMapping("/hasRestaurant")
    public Iterable<Hotel> findAllByHasRestaurant(boolean hasRestaurant){
        return hotelRepository.findAllByHasRestaurant(!hasRestaurant);
    }
    @GetMapping("/hasPool")
    public Iterable<Hotel> findAllByHasPool(boolean hasPool){
        return hotelRepository.findAllByHasPool(!hasPool);
    }
    @GetMapping("/hasKidsClub")
    public Iterable<Hotel> findAllByHasKidsClub(boolean hasKidsClub){
        return hotelRepository.findAllByHasKidsClub(!hasKidsClub);
    }
    @GetMapping("/hasEveningEntertainment")
    public Iterable<Hotel> findAllByHasEveningEntertainment(boolean hasEveningEntertainment){
        return hotelRepository.findAllByHasEveningEntertainment(!hasEveningEntertainment);
    }
    @GetMapping("/beachCloserThan/{metersToBeach}")
    public Iterable<Hotel> findAllByMetersToBeachIsLessThanEqual(@PathVariable int metersToBeach){

        return hotelRepository.findAllByMetersToBeachIsLessThanEqual(metersToBeach);
    }
    @GetMapping("/cityCenterCloserThan/{metersToCityCenter}")
    public Iterable<Hotel> findAllByMetersToCityCenterIsLessThanEqual(@PathVariable int metersToCityCenter){

        return hotelRepository.findAllByMetersToCityCenterIsLessThanEqual(metersToCityCenter);
    }
    @GetMapping("/rating/greaterEqual/{rating}")
    public Iterable<Hotel> findAllByRatingIsGreaterThanEqual(@PathVariable double rating){
        return hotelRepository.findAllByRatingIsGreaterThanEqual(rating);
    }
    @GetMapping("/rating/lessEqual/{rating}")
    public Iterable<Hotel> findAllByRatingIsLessThanEqual(@PathVariable double rating){
        return hotelRepository.findAllByRatingIsLessThanEqual(rating);
    }
    @GetMapping("/description/{description}")
    public Iterable<Hotel> findAllByDescriptionContains(@PathVariable String description){
        return hotelRepository.findAllByDescriptionContains(description);
    }


}
