package com.sn.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class Role implements Serializable {
    private Integer roleId;
    private String roleName;
    private String roleDesc;
    private List<User> users;
}
