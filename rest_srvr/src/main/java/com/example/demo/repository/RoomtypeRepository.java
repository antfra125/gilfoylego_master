package com.example.demo.repository;

import com.example.demo.entity.Roomtype;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomtypeRepository extends CrudRepository <Roomtype, Long>{
    Optional<Roomtype> findById(long id);
    Iterable<Roomtype> findAll();
}
