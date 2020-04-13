package com.sn.dao;

import com.sn.domain.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    User findById(Integer id);
    void update(User user);
}
