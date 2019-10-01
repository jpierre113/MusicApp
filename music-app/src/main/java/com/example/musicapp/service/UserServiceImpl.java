package com.example.musicapp.service;

import com.example.musicapp.models.User;
import com.example.musicapp.models.UserRole;
import com.example.musicapp.repository.UserRepository;
import com.example.musicapp.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;

    @Override
    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    //gets the role, assigns the role to user and creates the user in the database
    public User createUser(User newUser) {
        UserRole userRole = userRoleService.getRole("DBA");
        newUser.setUserRole(userRole);
        return userRepository.save(newUser);
    }

//    @Override
//    public User updateUser(User user) {
//        return userRepository.update(user);
//    }

    @Override
    public HttpStatus deleteById(Long userId) {
        userRepository.deleteById(userId);
        return null;
    }

    @Override
    public User login(String username, String password) {
        System.out.println("hi");
        return userRepository.login(username, password);
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }
    @Autowired
    UserRoleService userRoleService;

}