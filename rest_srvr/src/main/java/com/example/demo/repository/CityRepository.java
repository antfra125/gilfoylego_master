


package com.example.demo.repository;

import com.example.demo.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
    Optional<City>findById(long id);
    Iterable<City> findAllByName(String name);
    Iterable<City> findAllByCountryId(long countryId);
}
