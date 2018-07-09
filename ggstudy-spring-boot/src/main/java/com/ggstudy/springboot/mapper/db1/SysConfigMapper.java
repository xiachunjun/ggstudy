package com.ggstudy.springboot.mapper.db1;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.ggstudy.springboot.domain.SysConfig;

public interface SysConfigMapper {
    @Delete({
        "delete from ggstudy_sys_configs",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into ggstudy_sys_configs (id, cfg_code, ",
        "cfg_name, cfg_key, ",
        "cfg_value, cfg_des, ",
        "cfg_type, parent_code, ",
        "data_status, data_version, ",
        "create_at, update_at, ",
        "create_user, update_user)",
        "values (#{id,jdbcType=INTEGER}, #{cfgCode,jdbcType=VARCHAR}, ",
        "#{cfgName,jdbcType=VARCHAR}, #{cfgKey,jdbcType=VARCHAR}, ",
        "#{cfgValue,jdbcType=VARCHAR}, #{cfgDes,jdbcType=VARCHAR}, ",
        "#{cfgType,jdbcType=VARCHAR}, #{parentCode,jdbcType=VARCHAR}, ",
        "#{dataStatus,jdbcType=INTEGER}, #{dataVersion,jdbcType=INTEGER}, ",
        "#{createAt,jdbcType=TIMESTAMP}, #{updateAt,jdbcType=TIMESTAMP}, ",
        "#{createUser,jdbcType=VARCHAR}, #{updateUser,jdbcType=VARCHAR})"
    })
    int insert(SysConfig record);

    @Select({
        "select",
        "id, cfg_code, cfg_name, cfg_key, cfg_value, cfg_des, cfg_type, parent_code, ",
        "data_status, data_version, create_at, update_at, create_user, update_user",
        "from ggstudy_sys_configs",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="cfg_code", property="cfgCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="cfg_name", property="cfgName", jdbcType=JdbcType.VARCHAR),
        @Result(column="cfg_key", property="cfgKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="cfg_value", property="cfgValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="cfg_des", property="cfgDes", jdbcType=JdbcType.VARCHAR),
        @Result(column="cfg_type", property="cfgType", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_code", property="parentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_at", property="updateAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR)
    })
    SysConfig selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, cfg_code, cfg_name, cfg_key, cfg_value, cfg_des, cfg_type, parent_code, ",
        "data_status, data_version, create_at, update_at, create_user, update_user",
        "from ggstudy_sys_configs"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="cfg_code", property="cfgCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="cfg_name", property="cfgName", jdbcType=JdbcType.VARCHAR),
        @Result(column="cfg_key", property="cfgKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="cfg_value", property="cfgValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="cfg_des", property="cfgDes", jdbcType=JdbcType.VARCHAR),
        @Result(column="cfg_type", property="cfgType", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_code", property="parentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_at", property="updateAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR)
    })
    List<SysConfig> selectAll();

    @Update({
        "update ggstudy_sys_configs",
        "set cfg_code = #{cfgCode,jdbcType=VARCHAR},",
          "cfg_name = #{cfgName,jdbcType=VARCHAR},",
          "cfg_key = #{cfgKey,jdbcType=VARCHAR},",
          "cfg_value = #{cfgValue,jdbcType=VARCHAR},",
          "cfg_des = #{cfgDes,jdbcType=VARCHAR},",
          "cfg_type = #{cfgType,jdbcType=VARCHAR},",
          "parent_code = #{parentCode,jdbcType=VARCHAR},",
          "data_status = #{dataStatus,jdbcType=INTEGER},",
          "data_version = #{dataVersion,jdbcType=INTEGER},",
          "create_at = #{createAt,jdbcType=TIMESTAMP},",
          "update_at = #{updateAt,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "update_user = #{updateUser,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysConfig record);
}