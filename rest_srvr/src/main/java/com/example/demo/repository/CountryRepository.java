


package com.example.demo.repository;

import com.example.demo.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
    Country findById(int id);
    Country findByName(String name);
    List<Country> findAllByName(String name);
}
