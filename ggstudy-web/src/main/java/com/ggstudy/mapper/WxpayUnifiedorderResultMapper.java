package com.ggstudy.mapper;

import com.ggstudy.domain.WxpayUnifiedorderResult;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface WxpayUnifiedorderResultMapper {
    @Delete({
        "delete from rkl_wxpay_unifiedorder_results",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into rkl_wxpay_unifiedorder_results (id, ref_out_trade_no, ",
        "return_code, return_msg, ",
        "device_info, nonce_str, ",
        "sign, result_code, ",
        "err_code, err_code_des, ",
        "trade_type, prepay_id, ",
        "mweb_url, data_status, ",
        "data_version, create_at, ",
        "update_at, create_by, ",
        "update_by)",
        "values (#{id,jdbcType=INTEGER}, #{refOutTradeNo,jdbcType=VARCHAR}, ",
        "#{returnCode,jdbcType=VARCHAR}, #{returnMsg,jdbcType=VARCHAR}, ",
        "#{deviceInfo,jdbcType=VARCHAR}, #{nonceStr,jdbcType=VARCHAR}, ",
        "#{sign,jdbcType=VARCHAR}, #{resultCode,jdbcType=VARCHAR}, ",
        "#{errCode,jdbcType=VARCHAR}, #{errCodeDes,jdbcType=VARCHAR}, ",
        "#{tradeType,jdbcType=VARCHAR}, #{prepayId,jdbcType=VARCHAR}, ",
        "#{mwebUrl,jdbcType=VARCHAR}, #{dataStatus,jdbcType=INTEGER}, ",
        "#{dataVersion,jdbcType=INTEGER}, #{createAt,jdbcType=TIMESTAMP}, ",
        "#{updateAt,jdbcType=TIMESTAMP}, #{createBy,jdbcType=VARCHAR}, ",
        "#{updateBy,jdbcType=VARCHAR})"
    })
    int insert(WxpayUnifiedorderResult record);

    @Select({
        "select",
        "id, ref_out_trade_no, return_code, return_msg, device_info, nonce_str, sign, ",
        "result_code, err_code, err_code_des, trade_type, prepay_id, mweb_url, data_status, ",
        "data_version, create_at, update_at, create_by, update_by",
        "from rkl_wxpay_unifiedorder_results",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ref_out_trade_no", property="refOutTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="return_code", property="returnCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="return_msg", property="returnMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="device_info", property="deviceInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="nonce_str", property="nonceStr", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign", property="sign", jdbcType=JdbcType.VARCHAR),
        @Result(column="result_code", property="resultCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="err_code", property="errCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="err_code_des", property="errCodeDes", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_type", property="tradeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="prepay_id", property="prepayId", jdbcType=JdbcType.VARCHAR),
        @Result(column="mweb_url", property="mwebUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_at", property="updateAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR)
    })
    WxpayUnifiedorderResult selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, ref_out_trade_no, return_code, return_msg, device_info, nonce_str, sign, ",
        "result_code, err_code, err_code_des, trade_type, prepay_id, mweb_url, data_status, ",
        "data_version, create_at, update_at, create_by, update_by",
        "from rkl_wxpay_unifiedorder_results"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ref_out_trade_no", property="refOutTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="return_code", property="returnCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="return_msg", property="returnMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="device_info", property="deviceInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="nonce_str", property="nonceStr", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign", property="sign", jdbcType=JdbcType.VARCHAR),
        @Result(column="result_code", property="resultCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="err_code", property="errCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="err_code_des", property="errCodeDes", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_type", property="tradeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="prepay_id", property="prepayId", jdbcType=JdbcType.VARCHAR),
        @Result(column="mweb_url", property="mwebUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_at", property="updateAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR)
    })
    List<WxpayUnifiedorderResult> selectAll();

    @Update({
        "update rkl_wxpay_unifiedorder_results",
        "set ref_out_trade_no = #{refOutTradeNo,jdbcType=VARCHAR},",
          "return_code = #{returnCode,jdbcType=VARCHAR},",
          "return_msg = #{returnMsg,jdbcType=VARCHAR},",
          "device_info = #{deviceInfo,jdbcType=VARCHAR},",
          "nonce_str = #{nonceStr,jdbcType=VARCHAR},",
          "sign = #{sign,jdbcType=VARCHAR},",
          "result_code = #{resultCode,jdbcType=VARCHAR},",
          "err_code = #{errCode,jdbcType=VARCHAR},",
          "err_code_des = #{errCodeDes,jdbcType=VARCHAR},",
          "trade_type = #{tradeType,jdbcType=VARCHAR},",
          "prepay_id = #{prepayId,jdbcType=VARCHAR},",
          "mweb_url = #{mwebUrl,jdbcType=VARCHAR},",
          "data_status = #{dataStatus,jdbcType=INTEGER},",
          "data_version = #{dataVersion,jdbcType=INTEGER},",
          "create_at = #{createAt,jdbcType=TIMESTAMP},",
          "update_at = #{updateAt,jdbcType=TIMESTAMP},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "update_by = #{updateBy,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(WxpayUnifiedorderResult record);
}