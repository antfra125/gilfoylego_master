


package com.example.demo.repository;

import com.example.demo.entity.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Long> {
    Optional<Hotel> findById(long id);

    Iterable<Hotel> findAllByName(String name);
    Iterable<Hotel> findAllByCityId(long cityId);
    Iterable<Hotel> findAllByHasRestaurant(Boolean hasRestaurant);
    Iterable<Hotel> findAllByHasPool(Boolean hasPool);
    Iterable<Hotel> findAllByHasKidsClub(Boolean hasKidsClub);
    Iterable<Hotel> findAllByHasEveningEntertainment(Boolean hasNightEntertainment);
    Iterable<Hotel> findAllByMetersToBeach(int metersToBeach);
    Iterable<Hotel> findAllByMetersToCityCenter(int metersToCityCenter);
    Iterable<Hotel> findAllByRating(double rating);
    Iterable<Hotel> findAllByDescription(String description);
}
