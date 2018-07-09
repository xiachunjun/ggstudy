package com.ggstudy.mapper;

import com.ggstudy.domain.WxpayNotifyRecord;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface WxpayNotifyRecordMapper {
    @Delete({
        "delete from rkl_wxpay_notify_records",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into rkl_wxpay_notify_records (id, out_trade_no, ",
        "transaction_id, return_code, ",
        "return_msg, attach, ",
        "time_end, device_info, ",
        "nonce_str, sign, ",
        "sign_type, result_code, ",
        "err_code, err_code_des, ",
        "openid, is_subscribe, ",
        "trade_type, bank_type, ",
        "total_fee, settlement_total_fee, ",
        "fee_type, cash_fee, ",
        "cash_fee_type, coupon_fee, ",
        "coupon_count, data_status, ",
        "data_version, create_at, ",
        "update_at, create_by, ",
        "update_by)",
        "values (#{id,jdbcType=INTEGER}, #{outTradeNo,jdbcType=VARCHAR}, ",
        "#{transactionId,jdbcType=VARCHAR}, #{returnCode,jdbcType=VARCHAR}, ",
        "#{returnMsg,jdbcType=VARCHAR}, #{attach,jdbcType=VARCHAR}, ",
        "#{timeEnd,jdbcType=TIMESTAMP}, #{deviceInfo,jdbcType=VARCHAR}, ",
        "#{nonceStr,jdbcType=VARCHAR}, #{sign,jdbcType=VARCHAR}, ",
        "#{signType,jdbcType=VARCHAR}, #{resultCode,jdbcType=VARCHAR}, ",
        "#{errCode,jdbcType=VARCHAR}, #{errCodeDes,jdbcType=VARCHAR}, ",
        "#{openid,jdbcType=VARCHAR}, #{isSubscribe,jdbcType=VARCHAR}, ",
        "#{tradeType,jdbcType=VARCHAR}, #{bankType,jdbcType=VARCHAR}, ",
        "#{totalFee,jdbcType=INTEGER}, #{settlementTotalFee,jdbcType=INTEGER}, ",
        "#{feeType,jdbcType=VARCHAR}, #{cashFee,jdbcType=INTEGER}, ",
        "#{cashFeeType,jdbcType=VARCHAR}, #{couponFee,jdbcType=INTEGER}, ",
        "#{couponCount,jdbcType=INTEGER}, #{dataStatus,jdbcType=INTEGER}, ",
        "#{dataVersion,jdbcType=INTEGER}, #{createAt,jdbcType=TIMESTAMP}, ",
        "#{updateAt,jdbcType=TIMESTAMP}, #{createBy,jdbcType=VARCHAR}, ",
        "#{updateBy,jdbcType=VARCHAR})"
    })
    int insert(WxpayNotifyRecord record);

    @Select({
        "select",
        "id, out_trade_no, transaction_id, return_code, return_msg, attach, time_end, ",
        "device_info, nonce_str, sign, sign_type, result_code, err_code, err_code_des, ",
        "openid, is_subscribe, trade_type, bank_type, total_fee, settlement_total_fee, ",
        "fee_type, cash_fee, cash_fee_type, coupon_fee, coupon_count, data_status, data_version, ",
        "create_at, update_at, create_by, update_by",
        "from rkl_wxpay_notify_records",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="transaction_id", property="transactionId", jdbcType=JdbcType.VARCHAR),
        @Result(column="return_code", property="returnCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="return_msg", property="returnMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="attach", property="attach", jdbcType=JdbcType.VARCHAR),
        @Result(column="time_end", property="timeEnd", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="device_info", property="deviceInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="nonce_str", property="nonceStr", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign", property="sign", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign_type", property="signType", jdbcType=JdbcType.VARCHAR),
        @Result(column="result_code", property="resultCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="err_code", property="errCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="err_code_des", property="errCodeDes", jdbcType=JdbcType.VARCHAR),
        @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_subscribe", property="isSubscribe", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_type", property="tradeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_type", property="bankType", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_fee", property="totalFee", jdbcType=JdbcType.INTEGER),
        @Result(column="settlement_total_fee", property="settlementTotalFee", jdbcType=JdbcType.INTEGER),
        @Result(column="fee_type", property="feeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="cash_fee", property="cashFee", jdbcType=JdbcType.INTEGER),
        @Result(column="cash_fee_type", property="cashFeeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="coupon_fee", property="couponFee", jdbcType=JdbcType.INTEGER),
        @Result(column="coupon_count", property="couponCount", jdbcType=JdbcType.INTEGER),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_at", property="updateAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR)
    })
    WxpayNotifyRecord selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, out_trade_no, transaction_id, return_code, return_msg, attach, time_end, ",
        "device_info, nonce_str, sign, sign_type, result_code, err_code, err_code_des, ",
        "openid, is_subscribe, trade_type, bank_type, total_fee, settlement_total_fee, ",
        "fee_type, cash_fee, cash_fee_type, coupon_fee, coupon_count, data_status, data_version, ",
        "create_at, update_at, create_by, update_by",
        "from rkl_wxpay_notify_records"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="transaction_id", property="transactionId", jdbcType=JdbcType.VARCHAR),
        @Result(column="return_code", property="returnCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="return_msg", property="returnMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="attach", property="attach", jdbcType=JdbcType.VARCHAR),
        @Result(column="time_end", property="timeEnd", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="device_info", property="deviceInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="nonce_str", property="nonceStr", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign", property="sign", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign_type", property="signType", jdbcType=JdbcType.VARCHAR),
        @Result(column="result_code", property="resultCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="err_code", property="errCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="err_code_des", property="errCodeDes", jdbcType=JdbcType.VARCHAR),
        @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_subscribe", property="isSubscribe", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_type", property="tradeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_type", property="bankType", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_fee", property="totalFee", jdbcType=JdbcType.INTEGER),
        @Result(column="settlement_total_fee", property="settlementTotalFee", jdbcType=JdbcType.INTEGER),
        @Result(column="fee_type", property="feeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="cash_fee", property="cashFee", jdbcType=JdbcType.INTEGER),
        @Result(column="cash_fee_type", property="cashFeeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="coupon_fee", property="couponFee", jdbcType=JdbcType.INTEGER),
        @Result(column="coupon_count", property="couponCount", jdbcType=JdbcType.INTEGER),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_at", property="updateAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR)
    })
    List<WxpayNotifyRecord> selectAll();

    @Update({
        "update rkl_wxpay_notify_records",
        "set out_trade_no = #{outTradeNo,jdbcType=VARCHAR},",
          "transaction_id = #{transactionId,jdbcType=VARCHAR},",
          "return_code = #{returnCode,jdbcType=VARCHAR},",
          "return_msg = #{returnMsg,jdbcType=VARCHAR},",
          "attach = #{attach,jdbcType=VARCHAR},",
          "time_end = #{timeEnd,jdbcType=TIMESTAMP},",
          "device_info = #{deviceInfo,jdbcType=VARCHAR},",
          "nonce_str = #{nonceStr,jdbcType=VARCHAR},",
          "sign = #{sign,jdbcType=VARCHAR},",
          "sign_type = #{signType,jdbcType=VARCHAR},",
          "result_code = #{resultCode,jdbcType=VARCHAR},",
          "err_code = #{errCode,jdbcType=VARCHAR},",
          "err_code_des = #{errCodeDes,jdbcType=VARCHAR},",
          "openid = #{openid,jdbcType=VARCHAR},",
          "is_subscribe = #{isSubscribe,jdbcType=VARCHAR},",
          "trade_type = #{tradeType,jdbcType=VARCHAR},",
          "bank_type = #{bankType,jdbcType=VARCHAR},",
          "total_fee = #{totalFee,jdbcType=INTEGER},",
          "settlement_total_fee = #{settlementTotalFee,jdbcType=INTEGER},",
          "fee_type = #{feeType,jdbcType=VARCHAR},",
          "cash_fee = #{cashFee,jdbcType=INTEGER},",
          "cash_fee_type = #{cashFeeType,jdbcType=VARCHAR},",
          "coupon_fee = #{couponFee,jdbcType=INTEGER},",
          "coupon_count = #{couponCount,jdbcType=INTEGER},",
          "data_status = #{dataStatus,jdbcType=INTEGER},",
          "data_version = #{dataVersion,jdbcType=INTEGER},",
          "create_at = #{createAt,jdbcType=TIMESTAMP},",
          "update_at = #{updateAt,jdbcType=TIMESTAMP},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "update_by = #{updateBy,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(WxpayNotifyRecord record);
}