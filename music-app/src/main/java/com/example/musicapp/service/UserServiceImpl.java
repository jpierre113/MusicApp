package com.example.musicapp.service;

import com.example.musicapp.config.JwtUtil;
import com.example.musicapp.models.User;
import com.example.musicapp.models.UserRole;
import com.example.musicapp.repository.UserRepository;
import com.example.musicapp.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    @Qualifier("encoder")
    PasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUser(username);

        if(user==null)
            throw new UsernameNotFoundException("User null");

        return new org.springframework.security.core.userdetails.User(user.getUsername(), bCryptPasswordEncoder.encode(user.getPassword()),
                true, true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(user.getUserRole().getName()));

        return authorities;
    }


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
//    public User updateUserById(Long userId) {
//        return userRepository.update(userId);
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