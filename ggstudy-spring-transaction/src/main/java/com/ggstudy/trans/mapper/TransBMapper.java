package com.ggstudy.trans.mapper;

import com.ggstudy.trans.domain.TransB;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;


@Mapper
public interface TransBMapper {
    @Delete({
        "delete from ggstudy_trans_b",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into ggstudy_trans_b (trans_name, trans_pwd, ",
        "trans_status, create_time, ",
        "update_time)",
        "values (#{transName,jdbcType=VARCHAR}, #{transPwd,jdbcType=VARCHAR}, ",
        "#{transStatus,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(TransB record);

    @InsertProvider(type=TransBSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(TransB record);

    @Select({
        "select",
        "id, trans_name, trans_pwd, trans_status, create_time, update_time",
        "from ggstudy_trans_b",
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
    TransB selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TransBSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TransB record);

    @Update({
        "update ggstudy_trans_b",
        "set trans_name = #{transName,jdbcType=VARCHAR},",
          "trans_pwd = #{transPwd,jdbcType=VARCHAR},",
          "trans_status = #{transStatus,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TransB record);
}