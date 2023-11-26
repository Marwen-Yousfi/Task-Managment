package com.yousfi.taskmanagement.repository;

import com.yousfi.taskmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    // Custom query method to find a user by username
    User findByUsername(String username);

    // Custom query method to find a user by email
    User findByEmail(String email);

    // Custom query method to find users by a specific role
    List<User> findByRoles(String role);

    // Custom query method to find users with a certain status (active/inactive)
    List<User> findByActive(boolean active);

}
