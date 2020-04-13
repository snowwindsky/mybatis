package com.sn.dao;

import com.sn.domain.Account;

import java.util.List;

public interface AccountDao {
    List<Account> getAll();
    List<Account> findAccountByUid(Integer uid);
}
