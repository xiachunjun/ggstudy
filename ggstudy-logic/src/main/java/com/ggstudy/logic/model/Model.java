package com.ggstudy.logic.model;

import java.util.Date;

public class Model {
    private Integer key;
    private String name;

    public Model() {
    }

    public Model(Integer key, String name) {
        this.key = key;
        this.name = name;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
