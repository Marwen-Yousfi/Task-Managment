package com.yousfi.taskmanagement.service;

import com.yousfi.taskmanagement.model.User;
import com.yousfi.taskmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findByRoles(String role) {
        return userRepository.findByRoles(role);
    }

    public List<User> findByActive(boolean active) {
        return userRepository.findByActive(active);
    }

}
