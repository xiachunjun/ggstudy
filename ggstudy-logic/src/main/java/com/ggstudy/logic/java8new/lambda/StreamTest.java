package com.ggstudy.logic.java8new.lambda;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        test11();
        List<Byte> newDetailTypes = new ArrayList<>();
        System.out.println(newDetailTypes.indexOf("abbbbbbbbbbb"));

        System.out.println("abc".compareTo("abc"));

    }

    /**
     * stream并行、串行
     */
    public static void test1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.stream().forEach(System.out::println);// 有序
        System.out.println("========");
        numbers.parallelStream().forEach(System.out::println);// 并行，无序
        System.out.println("========");
        numbers.parallelStream().forEachOrdered(System.out::println);// 并行，排序，输出
    }

    public static void test2() {
        List<Dto> dtos = new ArrayList<Dto>();
        for (int i = 0; i < 20; i++) {
            dtos.add(new Dto("name" + i, new Date(), i % 2));
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        /**
         * 1、过滤出状态为1的
         * 2、按date倒叙排
         * 3、转list
         */
        List<Dto> dtosNew = dtos.stream().filter(billVO -> billVO.getStatus() == 1).sorted(Comparator.comparing(Dto::getDate).reversed()).collect(Collectors.toList());
        dtosNew.forEach((dto) -> {
            System.out.println(dto.getName());
        });
    }

    /**
     * 构建比较器
     *
     * @param keyExtractor
     *
     * @return
     */
    public static <T, U extends Comparable<? super U>> Comparator<T> comparing(Function<? super T, ? extends U> keyExtractor) {
        return (Comparator<T> & Serializable) (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
    }

    public static void test3() {
        List<Dto> dtos = new ArrayList<Dto>();
        for (int i = 0; i < 20; i++) {
            dtos.add(new Dto("name" + i, new Date(), i % 2));
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        /**
         * map是把stream中元素映射称为另一个元素
         */
        List<Date> dates = dtos.stream().map(Dto::getDate).collect(Collectors.toList());
//        List<String> names = dtos.stream().map(Dto::getName).collect(Collectors.toList());
        dates.forEach(System.out::println);
    }

    public static void test4() {
        List<Dto> dtos = new ArrayList<Dto>();
        for (int i = 0; i < 20; i++) {
            dtos.add(new Dto("name" + i, new Date(), i % 2));
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        Dto dto = dtos.stream().reduce((a, b) -> {
            a.setName(a.getName() + b.getName());
            return a;
        }).orElse(new Dto("1", new Date(), 1));
        System.out.println(dto.getName());
    }

    public static void test5() {
        List<Dto> dtos = new ArrayList<Dto>();
        List<Dto> rtos = new ArrayList<Dto>();
        for (int i = 0; i < 20; i++) {
            dtos.add(new Dto("name" + i, new Date(), i % 2));
            if (i % 2 == 0) {
                rtos.add(new Dto("name" + i, new Date(), i % 2));
            }
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        /**
         * allMatch当dtos中每一个元素都满足时，才返回true
         */
        boolean allMatch = dtos.stream().allMatch((s) -> s.getName().startsWith("name"));
        System.out.println("=============" + allMatch);

        /**
         * 从dtos中过滤掉name1
         * 当 d.getName()为"name1"时表达式：d.getName().compareTo("name1") != 0返回false，所以在d会被从dtos剔除
         */
        List<Dto> resos1 = dtos.stream().filter((d) -> d.getName().compareTo("name1") != 0).collect(Collectors.toList());
        resos1.stream().forEach(r -> {
            System.out.println(r.getName());
        });

        List<Dto> resos = dtos.stream().filter((d) -> rtos.stream().allMatch(r -> d.getName().compareTo(r.getName()) != 0)).collect(Collectors.toList());

        resos.stream().forEach(r -> {
            System.out.println(r.getName());
        });
    }

    public static void test6() {
        List<Dto> dtos = new ArrayList<Dto>();
        for (int i = 0; i < 20; i++) {
            dtos.add(new Dto("name" + i, new Date(), i % 2));
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        dtos.add(new Dto("name1", new Date(), 100));

        /*
         * Collectors.toMap转map操作
         * 1、key是Dto::getName，即dtos中每个元素去调用getName方法，作为map的key
         * 2、new一个HashMapmap作为map的value,其中存放dto的状态
         * 3、(v1,v2)->v2的作用是当发生key重复时使用
         *
         */
        Map<String, Map<String, String>> map = dtos.parallelStream().collect(Collectors.toMap(Dto::getName, dto -> {
            Map<String, String> m = new HashMap<String, String>();
            m.put("status", String.valueOf(dto.getStatus()));
            return m;
        }, (v1, v2) -> v2));
        System.out.println(map);
    }

    public static void test7() {
        /* 获取单词，并且去重 **/
        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world", "hello world welcome");

        // map和flatmap的区别
        list.stream().map(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("---------- ");
        list.stream().flatMap(item -> Arrays.stream(item.split(" "))).collect(Collectors.toList()).forEach(System.out::println);
    }

    public static void test8() {
        /* 获取单词，并且去重 **/
        List<String> list = Arrays.asList("a", "c", "x", "c", "d", "b", "g");

        List<String> list1 = list.parallelStream().sorted(String::compareTo).collect(Collectors.toList());
        List<String> list2 = list.parallelStream().sorted(Comparator.comparing(String::toString).reversed()).collect(Collectors.toList());
        System.out.print("使用String的compareTo方法排序，结果：");
        System.out.println(list1);
        System.out.print("Comparator.comparing方法排序，倒序，结果：");
        System.out.println(list2);
        System.out.print("前两次排序对原列表不影响，原列表：");
        System.out.println(list);

        list.sort((c1, c2) -> {
            return c1.compareTo(c2);
        });
        System.out.print("list.sort排序，对原列表元素顺序重新排列了，结果：");
        System.out.println(list);
    }

    /**
     * filter里面用return也是一样，不会导致提前返回
     */
    public static void test9() {
        List<String> aaa = new ArrayList<>();
        aaa.add("aaa");
        aaa.add("aaa");
        aaa.add("bb");
        aaa.add("aa");
        //用return不优雅
        List<String> b1 = aaa.stream().filter(e -> {
            return e.equals("aaa");
        }).collect(Collectors.toList());
        //这样应该刚好
        List<String> b2 = aaa.stream().filter(e -> e.equals("aaa")).collect(Collectors.toList());

        System.out.println(b1);
        System.out.println(b2);
    }

    /**
     *
     */
    public static void test10() {
        List<String> aaa = new ArrayList<>();
        aaa.add("aaa");
        aaa.add("aaa");
        aaa.add("bb");
        aaa.add("aa");

        List<String> b2 = aaa.stream().filter(e -> e.equals("ccc"))
                .map(e -> {
                    return new String(e);
                })
                .collect(Collectors.toList());

        System.out.println(b2);
    }

    public static void test11() {
        List<BigDecimal> aaa = new ArrayList<>();
        aaa.add(new BigDecimal(1));
        aaa.add(new BigDecimal(2));
        aaa.add(new BigDecimal(3));
        aaa.add(new BigDecimal(4));

        System.out.println(aaa.stream().reduce(BigDecimal.ZERO,BigDecimal::add));
    }



}
