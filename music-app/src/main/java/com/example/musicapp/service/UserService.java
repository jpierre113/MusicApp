package com.example.musicapp.service;

import com.example.musicapp.models.User;


public interface UserService {
    public Iterable<User> listUsers();
    public User createUser(User newUser);
}

