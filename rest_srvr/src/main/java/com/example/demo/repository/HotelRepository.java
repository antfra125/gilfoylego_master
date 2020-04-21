package com.example.demo.repository;

import com.example.demo.entity.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Long> {
    Iterable<Hotel> findAll();
    Optional<Hotel> findByIdEquals(long id);
    Iterable<Hotel> findAllByNameContains(String name);
    Iterable<Hotel> findAllByCityIdEquals(long cityId);
    Iterable<Hotel> findAllByHasRestaurant(boolean hasRestaurant);
    Iterable<Hotel> findAllByHasPool(boolean hasPool);
    Iterable<Hotel> findAllByHasKidsClub(boolean hasKidsClub);
    Iterable<Hotel> findAllByHasEveningEntertainment(boolean hasNightEntertainment);
    Iterable<Hotel> findAllByMetersToBeachIsLessThanEqual(int metersToBeach);
    Iterable<Hotel> findAllByMetersToCityCenterIsLessThanEqual(int metersToCityCenter);
    Iterable<Hotel> findAllByRatingIsGreaterThanEqual(double rating);
    Iterable<Hotel> findAllByRatingIsLessThanEqual(double rating);
    Iterable<Hotel> findAllByDescriptionContains(String description);
}
