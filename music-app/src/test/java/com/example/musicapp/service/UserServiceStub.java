package com.example.musicapp.service;

import com.example.musicapp.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceStub implements UserService {

    @Override
    public User getUser(String username) {
        User user = new User();
        user.setUsername(username);
        return user;
    }

    @Override
    public com.example.musicapp.models.User addSong(String username, int songId) {
        return null;
    }

    @Override
    public Iterable<com.example.musicapp.models.User> listUsers() {
        return null;
    }

    @Override
    public String createUser(com.example.musicapp.models.User newUser) {
        return null;
    }

    @Override
    public HttpStatus deleteById(Integer userId) {
        return null;
    }

    @Override
    public String login(com.example.musicapp.models.User user) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}