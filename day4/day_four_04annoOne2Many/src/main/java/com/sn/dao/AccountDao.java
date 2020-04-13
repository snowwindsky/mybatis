package com.sn.dao;

import com.sn.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
@CacheNamespace(blocking = true)
public interface AccountDao {
    @Select("SELECT * FROM account")
    @Results(id = "resultMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "user",column = "uid",one = @One(select = "com.sn.dao.UserDao.findById",fetchType = FetchType.EAGER)),
            @Result(property = "money",column = "money"),
    })
    List<Account> findAll();
    @Select("SELECT * FROM account WHERE uid=#{id}")
    List<Account> findAccountById(Integer id);
    @Select("SELECT * FROM account WHERE id=#{id}")
    Account findAccountByAId(Integer id);
}
