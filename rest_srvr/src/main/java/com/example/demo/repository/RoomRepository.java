


package com.example.demo.repository;

import com.example.demo.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    Optional<Room> findById(long id);
    Iterable<Room> findAllByHotelId(long hotelId);
    
    Iterable<Room> findAllById(long id);
    Iterable<Room> findAllBySizem2(int sizem2);
    Iterable<Room> findAllByPrice(double price);
}
