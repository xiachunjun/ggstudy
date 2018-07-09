package com.wanda.scheduler.model;

import java.util.Date;

public class MonitorBasePrice {
    private Long id;

    private String mbpBizcode;

    private String mbpName;

    private Long mbpBasePrice;

    private Integer dataStatus;

    private Integer dataVersion;

    private Date createAt;

    private Date updateAt;

    private String createUser;

    private String updateUser;

    private Integer dataType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMbpBizcode() {
        return mbpBizcode;
    }

    public void setMbpBizcode(String mbpBizcode) {
        this.mbpBizcode = mbpBizcode == null ? null : mbpBizcode.trim();
    }

    public String getMbpName() {
        return mbpName;
    }

    public void setMbpName(String mbpName) {
        this.mbpName = mbpName == null ? null : mbpName.trim();
    }

    public Long getMbpBasePrice() {
        return mbpBasePrice;
    }

    public void setMbpBasePrice(Long mbpBasePrice) {
        this.mbpBasePrice = mbpBasePrice;
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

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }
}