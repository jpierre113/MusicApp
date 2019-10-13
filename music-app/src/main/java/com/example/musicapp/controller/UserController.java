package com.example.musicapp.controller;

//import com.example.musicapp.model.JwtResponse;
import com.example.musicapp.models.JwtResponse;
import com.example.musicapp.models.User;
import com.example.musicapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        return ResponseEntity.ok(new JwtResponse(userService.login(user)));
    }

    @GetMapping("/user/list")
    public Iterable<User> listUsers() {
        return userService.listUsers();
    }

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        return ResponseEntity.ok(new JwtResponse(userService.createUser(newUser)));
    }


    @DeleteMapping("/user/{userId}")
    public HttpStatus deleteUserById(@PathVariable Integer userId) {
         userService.deleteById(userId);
            return HttpStatus.OK;
    }

    }

