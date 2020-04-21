package com.example.demo.rest;

import com.example.demo.entity.City;
import com.example.demo.entity.Country;
import com.example.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city") // Parent-URL:n för denna klass
public class CityController {

    //här vill jag ha Autowired, GetMapping, (och PostMapping?)
    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<City> findById(@PathVariable(required = false) long id) {
        return cityRepository.findById(id);
    }

    @GetMapping("/name/{name}")
    public Iterable<City> findAllByNameContains(@PathVariable(required = false) String name) {

        if (name == null) {
            //TODO lista ut varför vi aldrig hittar hit
            return cityRepository.findAll();
        } else {
            return cityRepository.findAllByNameContains(name);
        }
    }

    @GetMapping("/country/{countryId}")
    public Iterable<City> findAllByCountryId(@PathVariable long countryId) {
        return cityRepository.findAllByCountryId(countryId);
    }


}
