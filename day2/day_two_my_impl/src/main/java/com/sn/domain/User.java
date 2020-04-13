package com.sn.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class User implements Serializable{
    private Integer id;
    private String username;
    private Date birthday;
    private String address;
    private String sex;
}
