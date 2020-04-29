package com.example.demo.rest;

import com.example.demo.entity.Booking;
import com.example.demo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/last")
    public Long findLastId(){
        var alla = bookingRepository.findAll();
        var lastId = 0L;
        for (var a : alla){
            if (a.getId()>lastId){
                lastId = a.getId();
            }
        }
        return lastId;
    }
    @GetMapping
    public Iterable<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Booking> findById(@PathVariable long id) {
        return bookingRepository.findById(id);
    }

    @GetMapping("/user/{userId}")
    public Iterable<Booking> findAllByUserId(@PathVariable long userId) {
        return bookingRepository.findAllByUserId(userId);
    }

    @PostMapping
    public void createBooking(@RequestBody Booking bookingToBeCreated) {
        bookingRepository.save(bookingToBeCreated);
    }

    @PutMapping("/update")
    public String updateBooking(@RequestBody Booking booking) {
        bookingRepository.save(booking);
        return "Updated";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable long id) {
        System.out.println("[DEBUG] Trying to delete.");
        bookingRepository.deleteById(id);
        return "Deleted";
    }
}
