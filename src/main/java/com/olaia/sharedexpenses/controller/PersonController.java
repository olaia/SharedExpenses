package com.olaia.sharedexpenses.controller;

import com.olaia.sharedexpenses.domain.Person;
import com.olaia.sharedexpenses.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/friends")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping("/addFriend")
    public ResponseEntity addFriend(@RequestBody Person friend) {
        personService.addFriend(friend);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getBalance")
    public ResponseEntity getBalance(){
        Optional<List<Person>> friends = personService.getBalance();
        return friends.isPresent()
                ? ResponseEntity.ok(friends)
                : ResponseEntity.notFound().build();
    }
}
