package com.example.musicapp.service;

import com.example.musicapp.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    public Iterable<User> listUsers();
    public String createUser(User newUser);
    public HttpStatus deleteById(Long userId);
    public String login(User user);
    public User getUser(String username); //added for UserProfileImpl line 20 getUser
    public User addSong(String username, int songId);
}

