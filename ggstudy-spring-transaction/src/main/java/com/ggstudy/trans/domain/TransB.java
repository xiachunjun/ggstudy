package com.ggstudy.trans.domain;

import lombok.Data;

import java.util.Date;

@Data
public class TransB {
    private Integer id;

    private String transName;

    private String transPwd;

    private Integer transStatus;

    private Date createTime;

    private Date updateTime;

}