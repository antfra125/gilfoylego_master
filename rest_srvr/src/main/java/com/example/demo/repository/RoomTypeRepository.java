package com.example.demo.repository;

import com.example.demo.entity.RoomType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomTypeRepository extends CrudRepository <RoomType, Long>{
    Optional<RoomType> findByName(String name);
    Optional<RoomType> findById(long id);
}
