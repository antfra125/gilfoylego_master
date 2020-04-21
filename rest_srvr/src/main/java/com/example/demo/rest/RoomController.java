package com.example.demo.rest;

import com.example.demo.entity.Room;
import com.example.demo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;


    @GetMapping
    public Iterable<Room> findAll(){
        return roomRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Room> getSpecificRoom(@PathVariable long id) {
        return roomRepository.findById(id);
    }

    @GetMapping("hotelrooms/{hotelId}")
    public Iterable<Room> findAllRoomsInHotel(@PathVariable long hotelId) {
        return roomRepository.findAllByHotelId(hotelId);
    }

    @GetMapping("size/{sizem2}")
    public Iterable<Room> findAllRoomsBySizeM2(@PathVariable int sizem2) {
        return roomRepository.findAllBySizem2(sizem2);
    }

    @GetMapping("price/{price}")
    public Iterable<Room> findAllRoomsByPrice(@PathVariable double price) {
        return roomRepository.findAllByPrice(price);
    }
}
