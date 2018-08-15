package com.ggstudy.springboot.model;

import lombok.Data;

@Data
public class UserReq {
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

}
