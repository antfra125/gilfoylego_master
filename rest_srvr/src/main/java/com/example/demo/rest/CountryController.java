package com.example.demo.rest;

import com.example.demo.entity.Country;
import com.example.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("rest/Country") // Parent-URL:n för denna klass
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public Iterable<Country> findAllByName(@RequestParam(required = false) String name) {
        if (name == null) {
            return countryRepository.findAll();
        } else {
            return countryRepository.findAllByName(name);
        }
    }
    @GetMapping
    public Optional<Country> findById(@PathVariable int id){
        return Optional.of(countryRepository.findById(id));
    }
}
