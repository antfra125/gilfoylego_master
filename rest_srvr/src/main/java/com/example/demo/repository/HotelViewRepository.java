package com.example.demo.repository;

import com.example.demo.entity.HotelView;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelViewRepository extends CrudRepository<HotelView, Long> {

}
