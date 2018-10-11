package com.ggstudy.springboot.model;

import lombok.Data;

import java.util.List;

@Data
public class MockParamItem {
    private String paramKey;
    private String type;
    private Integer length;
    private String defaultValue;
    private List<String> randomList;
}
