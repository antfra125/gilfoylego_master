package com.example.demo.repository;

import com.example.demo.entity.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
    Iterable<Booking> findAll();

    Optional<Booking> findById(long id);

    Iterable<Booking> findAllByUserId(long id);
}
