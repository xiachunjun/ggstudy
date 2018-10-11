package com.ggstudy.springboot.model;

import lombok.Data;

import java.util.List;
@Data
public class MockRequest {
    private String tranCode;
    private List<MockParamItem> paramList;
}
