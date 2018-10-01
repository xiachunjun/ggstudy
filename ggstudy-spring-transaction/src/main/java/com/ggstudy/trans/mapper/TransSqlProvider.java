package com.ggstudy.trans.mapper;

import com.ggstudy.trans.domain.Trans;
import org.apache.ibatis.jdbc.SQL;

public class TransSqlProvider {

    public String insertSelective(Trans record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ggstudy_trans");
        
        if (record.getTransName() != null) {
            sql.VALUES("trans_name", "#{transName,jdbcType=VARCHAR}");
        }
        
        if (record.getTransPwd() != null) {
            sql.VALUES("trans_pwd", "#{transPwd,jdbcType=VARCHAR}");
        }
        
        if (record.getTransStatus() != null) {
            sql.VALUES("trans_status", "#{transStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Trans record) {
        SQL sql = new SQL();
        sql.UPDATE("ggstudy_trans");
        
        if (record.getTransName() != null) {
            sql.SET("trans_name = #{transName,jdbcType=VARCHAR}");
        }
        
        if (record.getTransPwd() != null) {
            sql.SET("trans_pwd = #{transPwd,jdbcType=VARCHAR}");
        }
        
        if (record.getTransStatus() != null) {
            sql.SET("trans_status = #{transStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}