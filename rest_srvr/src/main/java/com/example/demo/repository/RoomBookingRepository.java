package com.example.demo.repository;


import com.example.demo.entity.Room;
import com.example.demo.entity.RoomBooking;
import com.example.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface RoomBookingRepository extends CrudRepository<RoomBooking, Long> {
    Optional<RoomBooking> findById (long id);
    Iterable<RoomBooking> findAll();
    Iterable<RoomBooking> findAllByBookingId(Long bookingId);
    Iterable<RoomBooking> findAllByRoomId(Long roomId);
    Iterable<RoomBooking> findAllByDateCheckin(LocalDate dateCheckin);
    Iterable<RoomBooking> findAllByDateCheckout(LocalDate dateCheckout);
    void deleteById(long id);









}
