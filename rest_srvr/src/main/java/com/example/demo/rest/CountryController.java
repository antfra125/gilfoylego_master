package com.example.demo.rest;

import com.example.demo.entity.Country;
import com.example.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/country") // Parent-URL:n för denna klass
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public Iterable<Country> findAll(){
        return countryRepository.findAll();
    }

    @GetMapping ("/{id}")
    public Optional<Country> findById(@PathVariable(required = false) long id) {
            return countryRepository.findById(id);
    }

    /*
    @GetMapping ("/{name}")
    public Iterable<Country> findAllByName(@RequestParam(required = false) String name) {
        if (name == null) {
            return countryRepository.findAll();
        } else {
            return countryRepository.findAllByName(name);
        }
    }*/
}
