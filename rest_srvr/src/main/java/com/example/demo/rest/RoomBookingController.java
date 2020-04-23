package com.example.demo.rest;

import com.example.demo.entity.Room;
import com.example.demo.entity.RoomBooking;
import com.example.demo.entity.User;
import com.example.demo.repository.RoomBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/roombooking")
public class RoomBookingController {

    @Autowired
    private RoomBookingRepository roomBookingRepository;


    @GetMapping
    public Iterable<RoomBooking> findAll(){
        return roomBookingRepository.findAll();
    }

    @GetMapping("/{bookingId}_{roomId}_{dateCheckin}_{dateCheckout}")
    public Optional<RoomBooking> findByBookingIdAndRoomIdAndDateCheckinAndDateCheckout(@PathVariable long bookingId, @PathVariable long roomId, @PathVariable String dateCheckin, @PathVariable String dateCheckout) {
        LocalDate checkin = LocalDate.parse(dateCheckin);
        LocalDate checkout = LocalDate.parse(dateCheckout);
        return roomBookingRepository.findByBookingIdAndRoomIdAndDateCheckinAndDateCheckout(bookingId, roomId, checkin, checkout);
    }

    @GetMapping("booking/{bookingId}")
    public Iterable<RoomBooking> findAllByBookingId(@PathVariable long bookingId) {
        return roomBookingRepository.findAllByBookingId(bookingId);
    }

    @GetMapping("room/{roomId}")
    public Iterable<RoomBooking> findAllByRoomId(@PathVariable long roomId) {
        return roomBookingRepository.findAllByRoomId(roomId);
    }

    @GetMapping("checkin/{dateCheckin}")
    public Iterable<RoomBooking> findAllByDateCheckin(@PathVariable LocalDate dateCheckin) {
        return roomBookingRepository.findAllByDateCheckin(dateCheckin);
    }

    @GetMapping("checkout/{dateCheckout}")
    public Iterable<RoomBooking> findAllByDateCheckout(@PathVariable LocalDate dateCheckout) {
        return roomBookingRepository.findAllByDateCheckout(dateCheckout);
    }


    @PostMapping
    void createRoomBooking(@RequestBody RoomBooking RoomBookingToBeCreated) {
        roomBookingRepository.save(RoomBookingToBeCreated);
    }


    @PutMapping("/update")
    public String updateRoomBooking(@RequestBody RoomBooking roomBooking) {
        roomBookingRepository.save(roomBooking);
        return "Updated"; }

        
    @DeleteMapping("/{bookingId}_{roomId}_{dateCheckin}_{dateCheckout}")
    public void deleteByBookingIdAndRoomIdAndDateCheckinAndDateCheckout(@PathVariable long bookingId, @PathVariable long roomId, @PathVariable String dateCheckin, @PathVariable String dateCheckout) {
        LocalDate checkin = LocalDate.parse(dateCheckin);
        LocalDate checkout = LocalDate.parse(dateCheckout);
        roomBookingRepository.deleteByBookingIdAndRoomIdAndDateCheckinAndDateCheckout(bookingId, roomId, checkin, checkout);
    }
    }

