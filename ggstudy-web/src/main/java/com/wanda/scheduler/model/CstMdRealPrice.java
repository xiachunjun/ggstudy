package com.wanda.scheduler.model;

import java.util.Date;

public class CstMdRealPrice {
    private Long id;

    private String refMbpBizcode;

    private String refMbpName;

    private Long refCstId;

    private Long refMbpBasePrice;

    private Long realPrice;

    private Integer dataStatus;

    private Integer dataVersion;

    private String createUser;

    private String updateUser;

    private Date createAt;

    private Date updateAt;

    private String dataMemo;

    private Short dataType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefMbpBizcode() {
        return refMbpBizcode;
    }

    public void setRefMbpBizcode(String refMbpBizcode) {
        this.refMbpBizcode = refMbpBizcode == null ? null : refMbpBizcode.trim();
    }

    public String getRefMbpName() {
        return refMbpName;
    }

    public void setRefMbpName(String refMbpName) {
        this.refMbpName = refMbpName == null ? null : refMbpName.trim();
    }

    public Long getRefCstId() {
        return refCstId;
    }

    public void setRefCstId(Long refCstId) {
        this.refCstId = refCstId;
    }

    public Long getRefMbpBasePrice() {
        return refMbpBasePrice;
    }

    public void setRefMbpBasePrice(Long refMbpBasePrice) {
        this.refMbpBasePrice = refMbpBasePrice;
    }

    public Long getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Long realPrice) {
        this.realPrice = realPrice;
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

    public String getDataMemo() {
        return dataMemo;
    }

    public void setDataMemo(String dataMemo) {
        this.dataMemo = dataMemo == null ? null : dataMemo.trim();
    }

    public Short getDataType() {
        return dataType;
    }

    public void setDataType(Short dataType) {
        this.dataType = dataType;
    }
}