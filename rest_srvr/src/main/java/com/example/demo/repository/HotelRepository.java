package com.example.demo.repository;

import com.example.demo.entity.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Long> {
    Iterable<Hotel> findAll();
    Optional<Hotel> findById(long id);
    Iterable<Hotel> findAllByName(String name);
    Iterable<Hotel> findAllByCityId(long cityId);
    Iterable<Hotel> findAllByHasRestaurant(boolean hasRestaurant);
    Iterable<Hotel> findAllByHasPool(boolean hasPool);
    Iterable<Hotel> findAllByHasKidsClub(boolean hasKidsClub);
    Iterable<Hotel> findAllByHasEveningEntertainment(boolean hasNightEntertainment);
    Iterable<Hotel> findAllByMetersToBeach(int metersToBeach);
    Iterable<Hotel> findAllByMetersToCityCenter(int metersToCityCenter);
    Iterable<Hotel> findAllByRating(double rating);
    Iterable<Hotel> findAllByDescription(String description);
}
