package com.sn.dao;

import com.sn.domain.User;
import com.sn.mybatis.annotations.Select;

import java.util.List;

public interface UserDao {
    @Select("SELECT * FROM user")//注解方式
    List<User> findAll();
}
