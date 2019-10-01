package com.example.musicapp.service;

import com.example.musicapp.models.User;
import com.example.musicapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }

//    @Override
//    public User updateUser(User user) {
//        return userRepository.update(user);
//    }

    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User login(String username, String password) {
        return userRepository.login(username, password);
    }
}