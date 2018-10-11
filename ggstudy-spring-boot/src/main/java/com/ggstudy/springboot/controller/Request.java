package com.ggstudy.springboot.controller;

import lombok.Data;

import java.util.List;

@Data
public class Request {
    private String tranCode;
    private List<ParamItem> paramList;
}
