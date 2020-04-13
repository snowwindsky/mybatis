package com.sn.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class User implements Serializable{
    private Integer id;
    private String username;
    private Date birthday;
    private String address;
    private String sex;
    @Override
    public String toString(){
        return super.toString();
    }
}
