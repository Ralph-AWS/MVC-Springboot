package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Integer id);
    User save(User user);
    void deleteById(Integer id);
}