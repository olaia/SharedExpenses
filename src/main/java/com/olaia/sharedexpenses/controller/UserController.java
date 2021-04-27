package com.olaia.sharedexpenses.controller;

import com.olaia.sharedexpenses.domain.User;
import com.olaia.sharedexpenses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/friends")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addFriend")
    public ResponseEntity addFriend(@RequestBody User friend) {
        Optional<User> existingUser = userService.findByUsername(friend.getUsername());
        if (existingUser.isPresent()){
          friend.setBalance(existingUser.get().getBalance());
        }
        userService.addUser(friend);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getBalance")
    public ResponseEntity getBalance(){
        Optional<List<User>> friends = userService.getBalance();
        return friends.isPresent()
                ? ResponseEntity.ok(friends)
                : ResponseEntity.notFound().build();
    }
}
