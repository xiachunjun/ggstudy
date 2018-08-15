package com.ggstudy.springboot.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class User {
    private Integer id;

    /**
     * 用户代码
     */
    private String userCode;

    /**
     * 登录名
     */
    private String userLoginName;

    /**
     * 密码
     */
    private String userLoginPwd;

    /**
     * 身份证号
     */
    private String userIdCard;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 昵称
     */
    private String userNickname;

    private Integer dataState;

    @JsonIgnore
    private Integer dataVersion;

    @JsonIgnore
    private String createUser;

    @JsonIgnore
    private String updateUser;

    @JsonIgnore
    private Date createTime;

    @JsonIgnore
    private Date updateTime;

}