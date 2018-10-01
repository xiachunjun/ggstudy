package com.ggstudy.trans.mapper;

import com.ggstudy.trans.domain.Trans;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface TransMapper {
    @Delete({
        "delete from ggstudy_trans",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into ggstudy_trans (trans_name, trans_pwd, ",
        "trans_status, create_time, ",
        "update_time)",
        "values (#{transName,jdbcType=VARCHAR}, #{transPwd,jdbcType=VARCHAR}, ",
        "#{transStatus,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Trans record);

    @InsertProvider(type=TransSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Trans record);

    @Select({
        "select",
        "id, trans_name, trans_pwd, trans_status, create_time, update_time",
        "from ggstudy_trans",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="trans_name", property="transName", jdbcType=JdbcType.VARCHAR),
        @Result(column="trans_pwd", property="transPwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="trans_status", property="transStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Trans selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TransSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Trans record);

    @Update({
        "update ggstudy_trans",
        "set trans_name = #{transName,jdbcType=VARCHAR},",
          "trans_pwd = #{transPwd,jdbcType=VARCHAR},",
          "trans_status = #{transStatus,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Trans record);
}