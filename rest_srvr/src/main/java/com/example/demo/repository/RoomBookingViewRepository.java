package com.example.demo.repository;

import com.example.demo.entity.RoomBookingView;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomBookingViewRepository extends CrudRepository<RoomBookingView, Long> {
}
