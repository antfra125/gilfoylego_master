package com.example.demo.rest;

import com.example.demo.entity.Room;
import com.example.demo.entity.RoomBooking;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/roombooking")
public class RoomBookingController {
    void createRoomBooking(Room r, User u ){

    }
    /*
    void deleteRoomBookingById(Long id);

    */
}
