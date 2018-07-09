package com.ggstudy.springboot.domain;

import java.util.Date;

public class SysConfig {
    private Integer id;

    /**
     * 代码
     */
    private String cfgCode;

    /**
     * 名称
     */
    private String cfgName;

    /**
     * 键
     */
    private String cfgKey;

    /**
     * 值
     */
    private String cfgValue;

    /**
     * 描述
     */
    private String cfgDes;

    /**
     * 类型
     */
    private String cfgType;

    /**
     * 父code（多层级时使用）
     */
    private String parentCode;

    private Integer dataStatus;

    private Integer dataVersion;

    private Date createAt;

    private Date updateAt;

    private String createUser;

    private String updateUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCfgCode() {
        return cfgCode;
    }

    public void setCfgCode(String cfgCode) {
        this.cfgCode = cfgCode == null ? null : cfgCode.trim();
    }

    public String getCfgName() {
        return cfgName;
    }

    public void setCfgName(String cfgName) {
        this.cfgName = cfgName == null ? null : cfgName.trim();
    }

    public String getCfgKey() {
        return cfgKey;
    }

    public void setCfgKey(String cfgKey) {
        this.cfgKey = cfgKey == null ? null : cfgKey.trim();
    }

    public String getCfgValue() {
        return cfgValue;
    }

    public void setCfgValue(String cfgValue) {
        this.cfgValue = cfgValue == null ? null : cfgValue.trim();
    }

    public String getCfgDes() {
        return cfgDes;
    }

    public void setCfgDes(String cfgDes) {
        this.cfgDes = cfgDes == null ? null : cfgDes.trim();
    }

    public String getCfgType() {
        return cfgType;
    }

    public void setCfgType(String cfgType) {
        this.cfgType = cfgType == null ? null : cfgType.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public Integer getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    public Integer getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(Integer dataVersion) {
        this.dataVersion = dataVersion;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }
}