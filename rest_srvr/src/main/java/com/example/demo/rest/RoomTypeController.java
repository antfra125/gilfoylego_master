package com.example.demo.rest;

import com.example.demo.entity.Roomtype;
import com.example.demo.repository.RoomtypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/roomtype")
public class RoomTypeController {

    @Autowired
    private RoomtypeRepository roomtypeRepository;

    @GetMapping
    public Iterable<Roomtype> findAll(){
        return roomtypeRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Roomtype> findById(@PathVariable long id){
        return roomtypeRepository.findById(id);
    }

    /*
    @GetMapping("/{name}")
    public Optional<RoomType>findByName(@PathVariable String name){
        return roomTypeRepository.findByName(name);
    }*/
}
