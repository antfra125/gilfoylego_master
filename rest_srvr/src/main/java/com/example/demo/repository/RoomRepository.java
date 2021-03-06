


package com.example.demo.repository;

import com.example.demo.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    Iterable<Room> findAll();
    Optional<Room> findById(long id);
    Iterable<Room> findAllByHotelId(long hotelId);
    Iterable<Room> findAllBySizem2(int sizem2);
    Iterable<Room> findAllBySizem2GreaterThanEqual(int sizem2);
    Iterable<Room> findAllBySizem2LessThanEqual(int sizem2);
    Iterable<Room> findAllByPriceEquals(double price);
    Iterable<Room> findAllByPriceGreaterThanEqual(double price);
    Iterable<Room> findAllByPriceLessThanEqual(double price);
}
