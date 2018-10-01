package com.ggstudy.trans.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResponseModel {
    private String resultCode;
    private String resultMsg;
    private Map<String, Object> dataMap = new HashMap<>();

    public ResponseModel() {

    }

    public ResponseModel(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public static ResponseModel succecc() {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setResultCode("100000");
        responseModel.setResultMsg("成功");
        return responseModel;
    }

    public static ResponseModel fail() {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setResultCode("200000");
        responseModel.setResultMsg("失败");
        return responseModel;
    }
}
