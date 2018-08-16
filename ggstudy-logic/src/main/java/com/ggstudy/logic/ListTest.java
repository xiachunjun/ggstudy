package com.ggstudy.logic;

import com.ggstudy.logic.java8new.lambda.Dto;
import com.ggstudy.logic.model.Model;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListTest {

    public static void main(String[] args) {
        //		arrayListTest();
        test3();
    }


    public static void arrayListTest() {
        List<Integer> arrayList = new ArrayList<Integer>();

        /**
         * 边循环，边删除，存在的问题：
         *
         * 1、用for(int
         * i=0;i<list.size();i++)边循环，边remove(i)，会导致遗漏,因为删除之后你list数组后续项会向前移动
         * 2、foreach的话，会报ConcurrentModificationException
         *
         * 解决方案：
         *
         * 方法一：把要删除的元素先找出来，然后removerAll
         * 方法二：倒序遍历，然后删除，因为删除导致的数组变化是后面的元素往前移动，倒序遍历的时候，后面的元素已经遍历过了
         * 方法三：迭代器移除，要使用it.remove(),不能使用list.remove(i),否则还是报错
         * 方法四：java8中list新方法removeif（Predicate）
         *
         */
        // 方法一,删除2和4
        for (int i = 0; i < 5; i++) {
            arrayList.add(i);
        }
        List<Integer> needDelList = new ArrayList<Integer>();
        for (Integer integer : arrayList) {
            if (integer == 2 || integer == 4) {
                needDelList.add(integer);
            }
        }
        arrayList.removeAll(needDelList);
        System.out.println("方法一结果：" + arrayList);

        //方法二，删除2和4
        arrayList.clear();
        for (int i = 0; i < 5; i++) {
            arrayList.add(i);
        }
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (arrayList.get(i) == 2 || arrayList.get(i) == 4) {
                arrayList.remove(i);
            }
        }
        System.out.println("方法二结果：" + arrayList);

        //方法三，迭代器删除
        arrayList.clear();
        for (int i = 0; i < 5; i++) {
            arrayList.add(i);
        }
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            Integer inte = it.next();
            if (inte == 2 || inte == 4) {
                it.remove();
            }
        }
        System.out.println("方法三结果：" + arrayList);

        //方法四，java8
        arrayList.clear();
        for (int i = 0; i < 5; i++) {
            arrayList.add(i);
        }
        Predicate<Integer> p = new Predicate<Integer>() {
            @Override
            public boolean test(Integer t) {
                if (t == 2 || t == 4) {
                    return true;
                }
                return false;
            }
        };
        arrayList.removeIf(p);
        System.out.println("方法四结果：" + arrayList);

    }

    public static void test2() {

        List<String> list = Arrays.asList("abc");

        // class java.util.Arrays$ArrayList
        System.out.println(list.getClass());

        // class [Ljava.lang.String;
        Object[] objArray = list.toArray();
        System.out.println(objArray.getClass());

        objArray[0] = new Object();
    }

    /**
     * 两个list左链接
     * 先转map再处理，和for套for性能差异比较
     */
    public static void test3() {
        List<Model> list1 = new ArrayList<>();
        List<Model> list2 = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list1.add(new Model(i, "a"));
            list2.add(new Model(i, "b"));
        }
        Long begin = System.nanoTime();
        Map<Integer, Model> m1 = list1.stream().collect(Collectors.toMap(Model::getKey, model -> {
            return model;
        }));
        Map<Integer, Model> m2 = list2.stream().collect(Collectors.toMap(Model::getKey, model -> {
            return model;
        }));
        List<Model> list3 = m1.entrySet().stream().map(
                en -> {
                    en.getValue().setName(en.getValue().getName() + m2.get(en.getKey()).getName());
                    return en.getValue();
                }
        ).collect(Collectors.toList());
        Long end = System.nanoTime();
        System.out.println(end - begin);

        Long begin1 = System.nanoTime();
        for (Model mod1 : list1) {
            for (Model mod2 : list2) {
                if (mod1.getKey().equals(mod2.getKey())) {
                    mod1.setName(mod1.getName() + mod2.getName());
                }
            }
        }
        Long end1 = System.nanoTime();
        System.out.println(end1 - begin1);

    }
}
