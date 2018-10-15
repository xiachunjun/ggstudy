package com.ggstudy.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IfOrMapTest {
    //测试结果表明，hash效率高于if-else一个量级。当有大量分支，建议使用hash
    public static void main(String[] args) {
        IfOrMapTest ifOrMapTest = new IfOrMapTest();
        ifOrMapTest.ifTest();
        ifOrMapTest.mapTest();
    }

    public void mapTest() {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            stringList.add("aaaaa");
        }
        for (int i = 0; i < 10000; i++) {
            stringList.add("bbbbb");
        }
        for (int i = 0; i < 10000; i++) {
            stringList.add("ccccc");
        }

        Map<String, String> strMap = new HashMap<>();
        strMap.put("aaaaa", "aaaaa");
        strMap.put("bbbbb", "bbbbb");
        strMap.put("ccccc", "ccccc");
        Long begin = System.nanoTime();
        stringList.forEach(e -> strMap.get(e));
        Long end = System.nanoTime();
        System.out.println(end - begin);
    }

    public void ifTest() {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            stringList.add("aaaaa");
        }
        for (int i = 0; i < 10000; i++) {
            stringList.add("bbbbb");
        }
        Long begin = System.nanoTime();
        stringList.forEach(e -> {
                    if (e.equals("aaaaa")) {

                    } else if (e.equals("bbbbb")) {

                    } else {

                    }
                }
        );
        Long end = System.nanoTime();
        System.out.println(end - begin);
    }
}
