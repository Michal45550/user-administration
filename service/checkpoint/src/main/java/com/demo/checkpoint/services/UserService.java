package com.demo.checkpoint.services;

import com.demo.checkpoint.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User addUser(User user);

}
