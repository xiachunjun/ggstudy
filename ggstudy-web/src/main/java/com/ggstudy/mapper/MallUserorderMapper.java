package com.ggstudy.mapper;

import com.ggstudy.domain.MallUserorder;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface MallUserorderMapper {
    @Delete({
        "delete from rkl_mall_userorders",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into rkl_mall_userorders (id, qq, ",
        "begin_date, end_date, ",
        "total_fee, pay_type, ",
        "service_duration, data_status, ",
        "data_version, create_at, ",
        "update_at, create_by, ",
        "update_by)",
        "values (#{id,jdbcType=INTEGER}, #{qq,jdbcType=VARCHAR}, ",
        "#{beginDate,jdbcType=TIMESTAMP}, #{endDate,jdbcType=TIMESTAMP}, ",
        "#{totalFee,jdbcType=INTEGER}, #{payType,jdbcType=INTEGER}, ",
        "#{serviceDuration,jdbcType=INTEGER}, #{dataStatus,jdbcType=VARCHAR}, ",
        "#{dataVersion,jdbcType=VARCHAR}, #{createAt,jdbcType=TIMESTAMP}, ",
        "#{updateAt,jdbcType=TIMESTAMP}, #{createBy,jdbcType=VARCHAR}, ",
        "#{updateBy,jdbcType=VARCHAR})"
    })
    int insert(MallUserorder record);

    @Select({
        "select",
        "id, qq, begin_date, end_date, total_fee, pay_type, service_duration, data_status, ",
        "data_version, create_at, update_at, create_by, update_by",
        "from rkl_mall_userorders",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
        @Result(column="begin_date", property="beginDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="total_fee", property="totalFee", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_type", property="payType", jdbcType=JdbcType.INTEGER),
        @Result(column="service_duration", property="serviceDuration", jdbcType=JdbcType.INTEGER),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_at", property="updateAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR)
    })
    MallUserorder selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, qq, begin_date, end_date, total_fee, pay_type, service_duration, data_status, ",
        "data_version, create_at, update_at, create_by, update_by",
        "from rkl_mall_userorders"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
        @Result(column="begin_date", property="beginDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="total_fee", property="totalFee", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_type", property="payType", jdbcType=JdbcType.INTEGER),
        @Result(column="service_duration", property="serviceDuration", jdbcType=JdbcType.INTEGER),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_at", property="updateAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR)
    })
    List<MallUserorder> selectAll();

    @Update({
        "update rkl_mall_userorders",
        "set qq = #{qq,jdbcType=VARCHAR},",
          "begin_date = #{beginDate,jdbcType=TIMESTAMP},",
          "end_date = #{endDate,jdbcType=TIMESTAMP},",
          "total_fee = #{totalFee,jdbcType=INTEGER},",
          "pay_type = #{payType,jdbcType=INTEGER},",
          "service_duration = #{serviceDuration,jdbcType=INTEGER},",
          "data_status = #{dataStatus,jdbcType=VARCHAR},",
          "data_version = #{dataVersion,jdbcType=VARCHAR},",
          "create_at = #{createAt,jdbcType=TIMESTAMP},",
          "update_at = #{updateAt,jdbcType=TIMESTAMP},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "update_by = #{updateBy,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MallUserorder record);
}