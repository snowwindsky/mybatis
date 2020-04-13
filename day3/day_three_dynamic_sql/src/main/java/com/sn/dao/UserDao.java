package com.sn.dao;

import com.sn.domain.QueryVo;
import com.sn.domain.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    User findById(Integer id);
    List<User> findUserByName(String name);
    List<User> findByName(QueryVo queryVo);

    /**
     * 根据传入参数条件查询
     * @param user
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据id数组查询
     */
    List<User> findUserByIds(QueryVo queryVo);
}
