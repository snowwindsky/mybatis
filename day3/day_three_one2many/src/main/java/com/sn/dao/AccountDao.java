package com.sn.dao;

import com.sn.domain.Account;
import com.sn.domain.AccountUser;

import java.util.List;

public interface AccountDao {
    List<Account> getAll();
    List<AccountUser> getAllAccountUser();
}
