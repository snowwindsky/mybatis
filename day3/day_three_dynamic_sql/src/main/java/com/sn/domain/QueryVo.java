package com.sn.domain;

import lombok.Data;

import java.util.List;

@Data
public class QueryVo {
    private User user;
    private List<Integer> ids;
}
