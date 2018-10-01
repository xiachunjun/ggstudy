package com.ggstudy.trans.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Trans {
    private Integer id;

    private String transName;

    private String transPwd;

    private String transStatus;

    private Date createTime;

    private Date updateTime;
}