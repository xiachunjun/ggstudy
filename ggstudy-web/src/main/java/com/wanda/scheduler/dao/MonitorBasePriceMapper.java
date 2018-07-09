package com.wanda.scheduler.dao;

import com.wanda.scheduler.model.MonitorBasePrice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface MonitorBasePriceMapper {
    @Delete({
        "delete from CPT_MONITOR_BASE_PRICES",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into CPT_MONITOR_BASE_PRICES (ID, MBP_BIZCODE, ",
        "MBP_NAME, MBP_BASE_PRICE, ",
        "DATA_STATUS, DATA_VERSION, ",
        "CREATE_AT, UPDATE_AT, ",
        "CREATE_USER, UPDATE_USER, ",
        "DATA_TYPE)",
        "values (#{id,jdbcType=DECIMAL}, #{mbpBizcode,jdbcType=VARCHAR}, ",
        "#{mbpName,jdbcType=VARCHAR}, #{mbpBasePrice,jdbcType=DECIMAL}, ",
        "#{dataStatus,jdbcType=DECIMAL}, #{dataVersion,jdbcType=DECIMAL}, ",
        "#{createAt,jdbcType=TIMESTAMP}, #{updateAt,jdbcType=TIMESTAMP}, ",
        "#{createUser,jdbcType=VARCHAR}, #{updateUser,jdbcType=VARCHAR}, ",
        "#{dataType,jdbcType=DECIMAL})"
    })
    int insert(MonitorBasePrice record);

    @InsertProvider(type=MonitorBasePriceSqlProvider.class, method="insertSelective")
    int insertSelective(MonitorBasePrice record);

    @Select({
        "select",
        "ID, MBP_BIZCODE, MBP_NAME, MBP_BASE_PRICE, DATA_STATUS, DATA_VERSION, CREATE_AT, ",
        "UPDATE_AT, CREATE_USER, UPDATE_USER, DATA_TYPE",
        "from CPT_MONITOR_BASE_PRICES",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="MBP_BIZCODE", property="mbpBizcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="MBP_NAME", property="mbpName", jdbcType=JdbcType.VARCHAR),
        @Result(column="MBP_BASE_PRICE", property="mbpBasePrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="DATA_STATUS", property="dataStatus", jdbcType=JdbcType.DECIMAL),
        @Result(column="DATA_VERSION", property="dataVersion", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_AT", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_AT", property="updateAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_USER", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_USER", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="DATA_TYPE", property="dataType", jdbcType=JdbcType.DECIMAL)
    })
    MonitorBasePrice selectByPrimaryKey(Long id);

    @UpdateProvider(type=MonitorBasePriceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MonitorBasePrice record);

    @Update({
        "update CPT_MONITOR_BASE_PRICES",
        "set MBP_BIZCODE = #{mbpBizcode,jdbcType=VARCHAR},",
          "MBP_NAME = #{mbpName,jdbcType=VARCHAR},",
          "MBP_BASE_PRICE = #{mbpBasePrice,jdbcType=DECIMAL},",
          "DATA_STATUS = #{dataStatus,jdbcType=DECIMAL},",
          "DATA_VERSION = #{dataVersion,jdbcType=DECIMAL},",
          "CREATE_AT = #{createAt,jdbcType=TIMESTAMP},",
          "UPDATE_AT = #{updateAt,jdbcType=TIMESTAMP},",
          "CREATE_USER = #{createUser,jdbcType=VARCHAR},",
          "UPDATE_USER = #{updateUser,jdbcType=VARCHAR},",
          "DATA_TYPE = #{dataType,jdbcType=DECIMAL}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(MonitorBasePrice record);
}