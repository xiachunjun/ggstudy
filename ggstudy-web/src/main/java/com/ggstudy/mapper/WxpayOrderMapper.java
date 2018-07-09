package com.ggstudy.mapper;

import com.ggstudy.domain.WxpayOrder;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface WxpayOrderMapper {
    @Delete({
        "delete from rkl_wxpay_orders",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into rkl_wxpay_orders (id, device_info, ",
        "nonce_str, sign_type, ",
        "body, detail, attach, ",
        "out_trade_no, fee_type, ",
        "total_fee, spbill_create_ip, ",
        "time_start, time_expire, ",
        "goods_tag, notify_url, ",
        "trade_type, product_id, ",
        "limit_pay, openid, ",
        "scene_info, data_status, ",
        "data_version, create_at, ",
        "update_at, create_by, ",
        "update_by)",
        "values (#{id,jdbcType=INTEGER}, #{deviceInfo,jdbcType=VARCHAR}, ",
        "#{nonceStr,jdbcType=VARCHAR}, #{signType,jdbcType=VARCHAR}, ",
        "#{body,jdbcType=VARCHAR}, #{detail,jdbcType=VARCHAR}, #{attach,jdbcType=VARCHAR}, ",
        "#{outTradeNo,jdbcType=VARCHAR}, #{feeType,jdbcType=VARCHAR}, ",
        "#{totalFee,jdbcType=DECIMAL}, #{spbillCreateIp,jdbcType=VARCHAR}, ",
        "#{timeStart,jdbcType=TIMESTAMP}, #{timeExpire,jdbcType=TIMESTAMP}, ",
        "#{goodsTag,jdbcType=VARCHAR}, #{notifyUrl,jdbcType=VARCHAR}, ",
        "#{tradeType,jdbcType=VARCHAR}, #{productId,jdbcType=VARCHAR}, ",
        "#{limitPay,jdbcType=VARCHAR}, #{openid,jdbcType=VARCHAR}, ",
        "#{sceneInfo,jdbcType=VARCHAR}, #{dataStatus,jdbcType=INTEGER}, ",
        "#{dataVersion,jdbcType=INTEGER}, #{createAt,jdbcType=TIMESTAMP}, ",
        "#{updateAt,jdbcType=TIMESTAMP}, #{createBy,jdbcType=VARCHAR}, ",
        "#{updateBy,jdbcType=VARCHAR})"
    })
    int insert(WxpayOrder record);

    @Select({
        "select",
        "id, device_info, nonce_str, sign_type, body, detail, attach, out_trade_no, fee_type, ",
        "total_fee, spbill_create_ip, time_start, time_expire, goods_tag, notify_url, ",
        "trade_type, product_id, limit_pay, openid, scene_info, data_status, data_version, ",
        "create_at, update_at, create_by, update_by",
        "from rkl_wxpay_orders",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="device_info", property="deviceInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="nonce_str", property="nonceStr", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign_type", property="signType", jdbcType=JdbcType.VARCHAR),
        @Result(column="body", property="body", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail", property="detail", jdbcType=JdbcType.VARCHAR),
        @Result(column="attach", property="attach", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="fee_type", property="feeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_fee", property="totalFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="spbill_create_ip", property="spbillCreateIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="time_start", property="timeStart", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="time_expire", property="timeExpire", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="goods_tag", property="goodsTag", jdbcType=JdbcType.VARCHAR),
        @Result(column="notify_url", property="notifyUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_type", property="tradeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.VARCHAR),
        @Result(column="limit_pay", property="limitPay", jdbcType=JdbcType.VARCHAR),
        @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
        @Result(column="scene_info", property="sceneInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_at", property="updateAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR)
    })
    WxpayOrder selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, device_info, nonce_str, sign_type, body, detail, attach, out_trade_no, fee_type, ",
        "total_fee, spbill_create_ip, time_start, time_expire, goods_tag, notify_url, ",
        "trade_type, product_id, limit_pay, openid, scene_info, data_status, data_version, ",
        "create_at, update_at, create_by, update_by",
        "from rkl_wxpay_orders"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="device_info", property="deviceInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="nonce_str", property="nonceStr", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign_type", property="signType", jdbcType=JdbcType.VARCHAR),
        @Result(column="body", property="body", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail", property="detail", jdbcType=JdbcType.VARCHAR),
        @Result(column="attach", property="attach", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="fee_type", property="feeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_fee", property="totalFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="spbill_create_ip", property="spbillCreateIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="time_start", property="timeStart", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="time_expire", property="timeExpire", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="goods_tag", property="goodsTag", jdbcType=JdbcType.VARCHAR),
        @Result(column="notify_url", property="notifyUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_type", property="tradeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.VARCHAR),
        @Result(column="limit_pay", property="limitPay", jdbcType=JdbcType.VARCHAR),
        @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
        @Result(column="scene_info", property="sceneInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_at", property="updateAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR)
    })
    List<WxpayOrder> selectAll();

    @Update({
        "update rkl_wxpay_orders",
        "set device_info = #{deviceInfo,jdbcType=VARCHAR},",
          "nonce_str = #{nonceStr,jdbcType=VARCHAR},",
          "sign_type = #{signType,jdbcType=VARCHAR},",
          "body = #{body,jdbcType=VARCHAR},",
          "detail = #{detail,jdbcType=VARCHAR},",
          "attach = #{attach,jdbcType=VARCHAR},",
          "out_trade_no = #{outTradeNo,jdbcType=VARCHAR},",
          "fee_type = #{feeType,jdbcType=VARCHAR},",
          "total_fee = #{totalFee,jdbcType=DECIMAL},",
          "spbill_create_ip = #{spbillCreateIp,jdbcType=VARCHAR},",
          "time_start = #{timeStart,jdbcType=TIMESTAMP},",
          "time_expire = #{timeExpire,jdbcType=TIMESTAMP},",
          "goods_tag = #{goodsTag,jdbcType=VARCHAR},",
          "notify_url = #{notifyUrl,jdbcType=VARCHAR},",
          "trade_type = #{tradeType,jdbcType=VARCHAR},",
          "product_id = #{productId,jdbcType=VARCHAR},",
          "limit_pay = #{limitPay,jdbcType=VARCHAR},",
          "openid = #{openid,jdbcType=VARCHAR},",
          "scene_info = #{sceneInfo,jdbcType=VARCHAR},",
          "data_status = #{dataStatus,jdbcType=INTEGER},",
          "data_version = #{dataVersion,jdbcType=INTEGER},",
          "create_at = #{createAt,jdbcType=TIMESTAMP},",
          "update_at = #{updateAt,jdbcType=TIMESTAMP},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "update_by = #{updateBy,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(WxpayOrder record);
}