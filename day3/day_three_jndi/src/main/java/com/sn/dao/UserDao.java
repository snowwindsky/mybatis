package com.sn.dao;

import com.sn.domain.QueryVo;
import com.sn.domain.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Integer id);
    User findById(Integer id);
    List<User> findUserByName(String name);
    Integer getCount();
    List<User> findByName(QueryVo queryVo);
}
