package com.demo.checkpoint.services;

import com.demo.checkpoint.beans.UserBean;

import java.util.List;

public interface UserService {

    List<UserBean> getAll();

    UserBean addUser(UserBean user);

    void deleteUser(int id);

}
