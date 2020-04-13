package com.sn.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Account  implements Serializable{
    private Integer id;
    private Integer uid;
    private Double money;
    private User user;
}
