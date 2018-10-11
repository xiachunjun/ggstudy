package com.ggstudy.springboot.controller;

import lombok.Data;

import java.util.List;

@Data
public class ParamItem {
    private String paramKey;
    private String type;
    private Integer length;
    private String defaultValue;
    private List<String> randomList;
}
