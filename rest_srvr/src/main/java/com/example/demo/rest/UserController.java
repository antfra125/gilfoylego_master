package com.example.demo.rest;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
//@ResponseBody //<---(inkluderas automatiskt)
// gör så att responses konverteras till JSON
@RequestMapping("/user") //parent-URL:n för denna klass
public class UserController {
    @Autowired
    private UserRepository userRepository;


  @GetMapping
  public Iterable<User> findAll(){
      return userRepository.findAll();
  }
    @GetMapping("/{id}")
    public Optional<User> getSpecificUser(@PathVariable long id) {
        return userRepository.findById(id);
    }

    //behövs ens denna? jag tror inte det   [MVH MAGNUS]
    /*@GetMapping("/username/{username}")
    public Iterable<User> findAllByUsername(@PathVariable(required = false) String username) {
        System.out.println("username: "+username);
      if(username == null){
                System.out.println("");
                return userRepository.findAll();
            } else if (username.isBlank()) {

                System.out.println("isBlank");
                return userRepository.findAll();
            }
            else{
                System.out.println("inte null, försöker ngt");
                return userRepository.findAllByUsernameContains(username);
            }
    }
     */



    @PostMapping
    void createUser(@RequestBody User userToBeCreated) {
        userRepository.save(userToBeCreated);
    }


    /**
     * Skicka in en user,
     * skriv över user i userRepository som har samma id
     */

    @PutMapping("/update")
    public String updateUser(@RequestBody User user) {
        userRepository.save(user);
        return "Updated"; }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id) {
        userRepository.deleteById(id);
    }


}
