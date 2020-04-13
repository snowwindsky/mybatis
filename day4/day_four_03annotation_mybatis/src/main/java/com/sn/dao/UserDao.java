package com.sn.dao;

import com.sn.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {

    /**
     *
     * @return
     */
    @Select("SELECT * FROM user")
    List<User> findAll();

    @Insert("INSERT INTO user(username,address,sex,birthday) VALUES(#{username},#{address},#{sex},#{birthday})")
    void insert(User user);

    @Update("UPDATE user SET username=#{username},sex=#{sex},address=#{address},birthday=#{birthday} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM user where id=#{id}")
    void delete(Integer id);

    @Select("SELECT * FROM user where id =#{id}")
    User findById(Integer id);

    @Select("SELECT * FROM user WHERE username like #{username}")
    List<User> findByName(String name);

    @Select("SELECT count(*) FROM user")
    Integer findTotal();
}
