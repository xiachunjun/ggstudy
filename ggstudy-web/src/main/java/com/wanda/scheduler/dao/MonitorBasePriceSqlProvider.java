package com.wanda.scheduler.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.wanda.scheduler.model.MonitorBasePrice;

public class MonitorBasePriceSqlProvider {

    public String insertSelective(MonitorBasePrice record) {
        BEGIN();
        INSERT_INTO("CPT_MONITOR_BASE_PRICES");
        
        if (record.getId() != null) {
            VALUES("ID", "#{id,jdbcType=DECIMAL}");
        }
        
        if (record.getMbpBizcode() != null) {
            VALUES("MBP_BIZCODE", "#{mbpBizcode,jdbcType=VARCHAR}");
        }
        
        if (record.getMbpName() != null) {
            VALUES("MBP_NAME", "#{mbpName,jdbcType=VARCHAR}");
        }
        
        if (record.getMbpBasePrice() != null) {
            VALUES("MBP_BASE_PRICE", "#{mbpBasePrice,jdbcType=DECIMAL}");
        }
        
        if (record.getDataStatus() != null) {
            VALUES("DATA_STATUS", "#{dataStatus,jdbcType=DECIMAL}");
        }
        
        if (record.getDataVersion() != null) {
            VALUES("DATA_VERSION", "#{dataVersion,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateAt() != null) {
            VALUES("CREATE_AT", "#{createAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateAt() != null) {
            VALUES("UPDATE_AT", "#{updateAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUser() != null) {
            VALUES("CREATE_USER", "#{createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateUser() != null) {
            VALUES("UPDATE_USER", "#{updateUser,jdbcType=VARCHAR}");
        }
        
        if (record.getDataType() != null) {
            VALUES("DATA_TYPE", "#{dataType,jdbcType=DECIMAL}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(MonitorBasePrice record) {
        BEGIN();
        UPDATE("CPT_MONITOR_BASE_PRICES");
        
        if (record.getMbpBizcode() != null) {
            SET("MBP_BIZCODE = #{mbpBizcode,jdbcType=VARCHAR}");
        }
        
        if (record.getMbpName() != null) {
            SET("MBP_NAME = #{mbpName,jdbcType=VARCHAR}");
        }
        
        if (record.getMbpBasePrice() != null) {
            SET("MBP_BASE_PRICE = #{mbpBasePrice,jdbcType=DECIMAL}");
        }
        
        if (record.getDataStatus() != null) {
            SET("DATA_STATUS = #{dataStatus,jdbcType=DECIMAL}");
        }
        
        if (record.getDataVersion() != null) {
            SET("DATA_VERSION = #{dataVersion,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateAt() != null) {
            SET("CREATE_AT = #{createAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateAt() != null) {
            SET("UPDATE_AT = #{updateAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUser() != null) {
            SET("CREATE_USER = #{createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateUser() != null) {
            SET("UPDATE_USER = #{updateUser,jdbcType=VARCHAR}");
        }
        
        if (record.getDataType() != null) {
            SET("DATA_TYPE = #{dataType,jdbcType=DECIMAL}");
        }
        
        WHERE("ID = #{id,jdbcType=DECIMAL}");
        
        return SQL();
    }
}