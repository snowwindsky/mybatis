package com.sn.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class User implements Serializable{
    private Integer userId;
    private String userName;
    private Date userBirthday;
    private String userAddress;
    private String userSex;
}
