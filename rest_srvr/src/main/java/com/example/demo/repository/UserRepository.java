


package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByFirstName(String name);
    User findByUsername(String username);
    User findByAddress(String address);
    List<User> findAllByFirstName(String vadsom);
}
