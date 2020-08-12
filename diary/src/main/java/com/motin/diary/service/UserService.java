package com.motin.diary.service;

import com.motin.diary.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> saveAll(List<User> users);
    void delete(Long id);
    List<User> findAll();
    User findById(Long id);
    User findByPhone(String phone);
}
