package com.sn.dao;

import com.sn.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserDao {

    /**
     *
     * @return
     */
    @Select("SELECT * FROM user")
    @Results(id="resultMap",value = {
            @Result(id=true,property = "userId" ,column="id"),
            @Result(property = "userSex" ,column="sex"),
            @Result(property = "userName" ,column="userName"),
            @Result(property = "userAddress" ,column="address"),
            @Result(property = "userBirthday" ,column="birthday"),
            @Result(property = "accounts",column = "id",many = @Many(select = "com.sn.dao.AccountDao.findAccountById",fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    @Select("SELECT * FROM user where id =#{id}")
    @ResultMap("resultMap")
    User findById(Integer id);

    @ResultMap("resultMap")
    @Select("SELECT * FROM user WHERE username like #{username}")
    List<User> findByName(String name);

    @Select("SELECT count(*) FROM user")
    Integer findTotal();
}
