package com.example.demo.rest;

import com.example.demo.entity.City;
import com.example.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/City") // Parent-URL:n för denna klass
public class CityController {

    //här vill jag ha Autowired, GetMapping, (och PostMapping?)
    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    String testing(){return "detta meddelande visas nu på skärmen";}

    //slå ihop, ta emot 3 pathvariabler (optional)
    @GetMapping("/changeTHIS")
    public Optional<City> findById(@PathVariable int id) {
            return cityRepository.findById(id);
    }


    @GetMapping("/EDITHERE")
    public Iterable<City> findAllByName(@PathVariable String name) {
        if (name == null){
            return cityRepository.findAll();
        }
        else {
            return cityRepository.findAllByName(name);
        }
    }
    @GetMapping("findAllByCountryId")
    public Iterable<City> findAllByCountryId(@PathVariable long countryId) {
        return cityRepository.findAllByCountryId(countryId);
    }


}
