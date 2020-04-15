


package com.example.demo.repository;

import com.example.demo.entity.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Long> {
    Hotel findById(int id);
    Hotel findByName(String name);
    Hotel findByHasRestaurant(Boolean hasRestaurant);
    Hotel findByHasPool(Boolean hasPool);
    Hotel findByHasKidsClub(Boolean hasKidsClub);
    Hotel findByHasNightEntertainment(Boolean hasNightEntertainment);
    Hotel findByMToBeach(int mToBeach);
    Hotel findByMToCity(int mToCity);
    Hotel findByRating(double rating);
    Hotel findByDescription(String description);

    List<Hotel> findAllByName(String name);
    List<Hotel> findAllByHasRestaurant(Boolean hasRestaurant);
    List<Hotel> findAllByHasPool(Boolean hasPool);
    List<Hotel> findAllByHasKidsClub(Boolean hasKidsClub);
    List<Hotel> findAllByHasNightEntertainment(Boolean hasNightEntertainment);
    List<Hotel> findAllByMToBeach(int mToBeach);
    List<Hotel> findAllByMToCity(int mToCity);
    List<Hotel> findAllByRating(double rating);
    List<Hotel> findAllByDescription(String description);
}
