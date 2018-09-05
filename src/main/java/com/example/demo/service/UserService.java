package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    public User findUserByEmail(String email);

    public void saveUser(User user);

}
