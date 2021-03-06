package com.sn.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
public class Account implements Serializable {
    private Integer id;
    private Integer uid;
    private Double money;
    //一对一
    //从表实体应该包含一个主表实体的对象引用
    private User user;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }
}
