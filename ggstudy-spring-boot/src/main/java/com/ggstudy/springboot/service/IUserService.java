package com.ggstudy.springboot.service;

import com.ggstudy.springboot.domain.User;

import java.util.List;

public interface IUserService {

    void addUser(User user);

    void updateUser(User user);

    void updateUserAsyc(User user);

     List<User> queryAll();
}
