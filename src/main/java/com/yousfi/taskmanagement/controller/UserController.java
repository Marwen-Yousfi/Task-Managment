package com.yousfi.taskmanagement.controller;

import com.yousfi.taskmanagement.model.User;
import com.yousfi.taskmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/by-username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/by-email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @GetMapping("/by-role/{role}")
    public List<User> getUsersByRole(@PathVariable String role) {
        return userService.findByRoles(role);
    }

    @GetMapping("/by-active/{active}")
    public List<User> getUsersByActiveStatus(@PathVariable boolean active) {
        return userService.findByActive(active);
    }
}