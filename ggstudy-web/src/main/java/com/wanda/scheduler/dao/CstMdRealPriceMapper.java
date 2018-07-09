package com.wanda.scheduler.dao;

import com.wanda.scheduler.model.CstMdRealPrice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CstMdRealPriceMapper {
    @Delete({
        "delete from CPT_CST_MD_REAL_PRICES",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into CPT_CST_MD_REAL_PRICES (ID, REF_MBP_BIZCODE, ",
        "REF_MBP_NAME, REF_CST_ID, ",
        "REF_MBP_BASE_PRICE, REAL_PRICE, ",
        "DATA_STATUS, DATA_VERSION, ",
        "CREATE_USER, UPDATE_USER, ",
        "CREATE_AT, UPDATE_AT, ",
        "DATA_MEMO, DATA_TYPE)",
        "values (#{id,jdbcType=DECIMAL}, #{refMbpBizcode,jdbcType=VARCHAR}, ",
        "#{refMbpName,jdbcType=VARCHAR}, #{refCstId,jdbcType=DECIMAL}, ",
        "#{refMbpBasePrice,jdbcType=DECIMAL}, #{realPrice,jdbcType=DECIMAL}, ",
        "#{dataStatus,jdbcType=DECIMAL}, #{dataVersion,jdbcType=DECIMAL}, ",
        "#{createUser,jdbcType=VARCHAR}, #{updateUser,jdbcType=VARCHAR}, ",
        "#{createAt,jdbcType=TIMESTAMP}, #{updateAt,jdbcType=TIMESTAMP}, ",
        "#{dataMemo,jdbcType=VARCHAR}, #{dataType,jdbcType=DECIMAL})"
    })
    int insert(CstMdRealPrice record);

    @InsertProvider(type=CstMdRealPriceSqlProvider.class, method="insertSelective")
    int insertSelective(CstMdRealPrice record);

    @Select({
        "select",
        "ID, REF_MBP_BIZCODE, REF_MBP_NAME, REF_CST_ID, REF_MBP_BASE_PRICE, REAL_PRICE, ",
        "DATA_STATUS, DATA_VERSION, CREATE_USER, UPDATE_USER, CREATE_AT, UPDATE_AT, DATA_MEMO, ",
        "DATA_TYPE",
        "from CPT_CST_MD_REAL_PRICES",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REF_MBP_BIZCODE", property="refMbpBizcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="REF_MBP_NAME", property="refMbpName", jdbcType=JdbcType.VARCHAR),
        @Result(column="REF_CST_ID", property="refCstId", jdbcType=JdbcType.DECIMAL),
        @Result(column="REF_MBP_BASE_PRICE", property="refMbpBasePrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="REAL_PRICE", property="realPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="DATA_STATUS", property="dataStatus", jdbcType=JdbcType.DECIMAL),
        @Result(column="DATA_VERSION", property="dataVersion", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_USER", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_USER", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_AT", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_AT", property="updateAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="DATA_MEMO", property="dataMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="DATA_TYPE", property="dataType", jdbcType=JdbcType.DECIMAL)
    })
    CstMdRealPrice selectByPrimaryKey(Long id);

    @UpdateProvider(type=CstMdRealPriceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CstMdRealPrice record);

    @Update({
        "update CPT_CST_MD_REAL_PRICES",
        "set REF_MBP_BIZCODE = #{refMbpBizcode,jdbcType=VARCHAR},",
          "REF_MBP_NAME = #{refMbpName,jdbcType=VARCHAR},",
          "REF_CST_ID = #{refCstId,jdbcType=DECIMAL},",
          "REF_MBP_BASE_PRICE = #{refMbpBasePrice,jdbcType=DECIMAL},",
          "REAL_PRICE = #{realPrice,jdbcType=DECIMAL},",
          "DATA_STATUS = #{dataStatus,jdbcType=DECIMAL},",
          "DATA_VERSION = #{dataVersion,jdbcType=DECIMAL},",
          "CREATE_USER = #{createUser,jdbcType=VARCHAR},",
          "UPDATE_USER = #{updateUser,jdbcType=VARCHAR},",
          "CREATE_AT = #{createAt,jdbcType=TIMESTAMP},",
          "UPDATE_AT = #{updateAt,jdbcType=TIMESTAMP},",
          "DATA_MEMO = #{dataMemo,jdbcType=VARCHAR},",
          "DATA_TYPE = #{dataType,jdbcType=DECIMAL}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(CstMdRealPrice record);
}