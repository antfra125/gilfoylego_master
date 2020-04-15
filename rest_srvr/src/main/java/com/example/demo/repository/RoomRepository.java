


package com.example.demo.repository;

import com.example.demo.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    Room findById(int id);
    Room findByHotelId(int hotelId);
    Room findByArea(int m2);
    Room findByPrice(double price);
    
    List<Room> findAllById(int id);
    List<Room> findAllByAreaM2(int m2);
    List<Room> findAllByPrice(double price);
}
