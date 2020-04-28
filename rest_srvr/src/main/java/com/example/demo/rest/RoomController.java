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

    @GetMapping("size/greaterEqual/{sizem2}")
    public Iterable<Room> findAllRoomsBySizem2GreaterThanEqual(@PathVariable int sizem2) {
        return roomRepository.findAllBySizem2GreaterThanEqual(sizem2);
    }
    @GetMapping("size/lessEqual/{sizem2}")
    public Iterable<Room> findAllRoomsBySizem2LessThanEqual(@PathVariable int sizem2) {
        return roomRepository.findAllBySizem2LessThanEqual(sizem2);
    }

    @GetMapping("price/greaterEqual/{price}")
    public Iterable<Room> findAllRoomsByPriceGreaterThanEqual(@PathVariable double price) {
        return roomRepository.findAllByPriceGreaterThanEqual(price);
    }

    @GetMapping("price/lessEqual/{price}")
    public Iterable<Room> findAllRoomsByPriceLessThanEqual(@PathVariable double price) {
        return roomRepository.findAllByPriceLessThanEqual(price);
    }

    @GetMapping("price/equals/{price}")
    public Iterable<Room> findAllRoomsByPriceEquals(@PathVariable double price) {
        return roomRepository.findAllByPriceEquals(price);
    }
}
