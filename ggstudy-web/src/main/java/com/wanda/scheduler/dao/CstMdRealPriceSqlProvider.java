package com.wanda.scheduler.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.wanda.scheduler.model.CstMdRealPrice;

public class CstMdRealPriceSqlProvider {

    public String insertSelective(CstMdRealPrice record) {
        BEGIN();
        INSERT_INTO("CPT_CST_MD_REAL_PRICES");
        
        if (record.getId() != null) {
            VALUES("ID", "#{id,jdbcType=DECIMAL}");
        }
        
        if (record.getRefMbpBizcode() != null) {
            VALUES("REF_MBP_BIZCODE", "#{refMbpBizcode,jdbcType=VARCHAR}");
        }
        
        if (record.getRefMbpName() != null) {
            VALUES("REF_MBP_NAME", "#{refMbpName,jdbcType=VARCHAR}");
        }
        
        if (record.getRefCstId() != null) {
            VALUES("REF_CST_ID", "#{refCstId,jdbcType=DECIMAL}");
        }
        
        if (record.getRefMbpBasePrice() != null) {
            VALUES("REF_MBP_BASE_PRICE", "#{refMbpBasePrice,jdbcType=DECIMAL}");
        }
        
        if (record.getRealPrice() != null) {
            VALUES("REAL_PRICE", "#{realPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getDataStatus() != null) {
            VALUES("DATA_STATUS", "#{dataStatus,jdbcType=DECIMAL}");
        }
        
        if (record.getDataVersion() != null) {
            VALUES("DATA_VERSION", "#{dataVersion,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateUser() != null) {
            VALUES("CREATE_USER", "#{createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateUser() != null) {
            VALUES("UPDATE_USER", "#{updateUser,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateAt() != null) {
            VALUES("CREATE_AT", "#{createAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateAt() != null) {
            VALUES("UPDATE_AT", "#{updateAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDataMemo() != null) {
            VALUES("DATA_MEMO", "#{dataMemo,jdbcType=VARCHAR}");
        }
        
        if (record.getDataType() != null) {
            VALUES("DATA_TYPE", "#{dataType,jdbcType=DECIMAL}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(CstMdRealPrice record) {
        BEGIN();
        UPDATE("CPT_CST_MD_REAL_PRICES");
        
        if (record.getRefMbpBizcode() != null) {
            SET("REF_MBP_BIZCODE = #{refMbpBizcode,jdbcType=VARCHAR}");
        }
        
        if (record.getRefMbpName() != null) {
            SET("REF_MBP_NAME = #{refMbpName,jdbcType=VARCHAR}");
        }
        
        if (record.getRefCstId() != null) {
            SET("REF_CST_ID = #{refCstId,jdbcType=DECIMAL}");
        }
        
        if (record.getRefMbpBasePrice() != null) {
            SET("REF_MBP_BASE_PRICE = #{refMbpBasePrice,jdbcType=DECIMAL}");
        }
        
        if (record.getRealPrice() != null) {
            SET("REAL_PRICE = #{realPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getDataStatus() != null) {
            SET("DATA_STATUS = #{dataStatus,jdbcType=DECIMAL}");
        }
        
        if (record.getDataVersion() != null) {
            SET("DATA_VERSION = #{dataVersion,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateUser() != null) {
            SET("CREATE_USER = #{createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateUser() != null) {
            SET("UPDATE_USER = #{updateUser,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateAt() != null) {
            SET("CREATE_AT = #{createAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateAt() != null) {
            SET("UPDATE_AT = #{updateAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDataMemo() != null) {
            SET("DATA_MEMO = #{dataMemo,jdbcType=VARCHAR}");
        }
        
        if (record.getDataType() != null) {
            SET("DATA_TYPE = #{dataType,jdbcType=DECIMAL}");
        }
        
        WHERE("ID = #{id,jdbcType=DECIMAL}");
        
        return SQL();
    }
}