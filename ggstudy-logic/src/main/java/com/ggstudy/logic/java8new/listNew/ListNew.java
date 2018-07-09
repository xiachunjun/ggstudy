package com.ggstudy.logic.java8new.listNew;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ListNew {
	public static void main(String[] args) {
		newThing1();
	}

	public static void newThing1() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");

		for (Object n : list) {
			System.out.println(n);
		}

		list.forEach(n -> System.out.println(n));

		list.forEach(System.out::println);

		list.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t + "-----");
			}
		});

	}
}
