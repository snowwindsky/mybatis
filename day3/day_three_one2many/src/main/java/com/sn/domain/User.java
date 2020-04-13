package com.sn.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ToString
public class User implements Serializable{
    private Integer id;
    private String username;
    private Date birthday;
    private String address;
    private String sex;
    //一对多
    //一对多关系映射，主表实体应该包含从表实体的集合引用
    private List<Account> accounts;
}
