package com.example.Article.interfaces;

import com.example.Article.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User updatedUser);
    void deleteUser(Long id);
    User findById(Long id);
    Optional<User> findByUsername(String username);
}