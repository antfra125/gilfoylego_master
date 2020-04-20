


package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Iterable<User> findAll();
    Iterable<User> findAllByUsername(String username);
    Optional<User> findById(Long id);

    void createUser(User u);
    void deleteById(Long id);
}
