package com.example.spring_3_1_5.service;

import com.example.spring_3_1_5.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    List<User> getUserList();

    void addUser(User user);

    void updateUser(long id, User updateUser);

    void deleteUser(long id);

    User findByEmail(String email);

}
