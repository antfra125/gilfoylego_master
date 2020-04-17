


package com.example.demo.repository;

import com.example.demo.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
    City findById(int id);
    List<City> findAllByName(String name);
    List<City> findAllByCountryId(int countryId);
}
