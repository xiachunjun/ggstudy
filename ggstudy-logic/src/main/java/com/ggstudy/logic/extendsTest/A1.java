package com.ggstudy.logic.extendsTest;

public class A1 extends AbstractA<B> {


    public A1() {
        super(new String("ssssssss"));
    }

    @Override
    String toStr(B b) {
        return b.toString();
    }

    public static void main(String[] args) {
        A1 a1 = new A1();
        a1.say(new B());
    }
}
