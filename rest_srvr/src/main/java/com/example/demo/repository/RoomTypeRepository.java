package com.example.demo.repository;

import com.example.demo.entity.RoomType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends CrudRepository <RoomType, Long>{
    RoomType findByName(String name);
    RoomType findById(long id);
}
