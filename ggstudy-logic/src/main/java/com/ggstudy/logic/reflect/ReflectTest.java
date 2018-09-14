package com.ggstudy.logic.reflect;

import java.util.ArrayList;
import java.util.List;

public class ReflectTest {
    public static <T> List<T> getT(Class<T> clazz){

        List<T> objList=new ArrayList<T>();
        try {
            objList.add(clazz.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objList;
    }

    public static void main(String[] args) {
        List<String> aList = getT(String.class);
        aList.add("test");
        System.out.println(aList.get(0));
    }

}
