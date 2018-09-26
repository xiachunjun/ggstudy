package com.ggstudy.logic.extendsTest;

public abstract class AbstractA<T> {
    String name;

    public AbstractA(String name) {
        this.name = name;
    }

    public void say(T t) {
        System.out.println(this.toStr(t) + name);
    }

    abstract String toStr(T t);
}
