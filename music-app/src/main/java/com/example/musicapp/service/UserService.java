package com.example.musicapp.service;

import com.example.musicapp.models.User;
import org.springframework.http.HttpStatus;


public interface UserService {
    public Iterable<User> listUsers();
    public User createUser(User newUser);
    public HttpStatus deleteById(Long userId);
    public User login(String username, String password);

}

