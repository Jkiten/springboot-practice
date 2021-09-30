package com.kiyeol.controller;

import com.kiyeol.domain.User;
import com.kiyeol.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> Users(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping("/user-save")
    public ResponseEntity createUser(@Validated @RequestBody User user){
        User result = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
