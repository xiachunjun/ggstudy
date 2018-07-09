package com.ggstudy.logic.suanfa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xcj Arraylist的包含方法以及hashmap的get方法的效率比较
 */
public class ListContainAndHashMapGet {
	static Map<String, Boolean> map = new HashMap<String, Boolean>();
	static List<String> list = new ArrayList<String>();
	static {
		map.put("AAA", true);
		map.put("BBB", true);
		map.put("CCC", true);
		map.put("DDD", true);
		map.put("EEE", true);
		map.put("FFF", true);
		map.put("GGG", true);
		map.put("HHH", true);
		map.put("III", true);
		list.add("AAA");
		list.add("BBB");
		list.add("CCC");
		list.add("DDD");
		list.add("EEE");
		list.add("FFF");
		list.add("GGG");
		list.add("HHH");
		list.add("III");

	}

	public static void main(String[] args) {
		long s1 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			map.get("EEE");
		}
		long e1 = System.currentTimeMillis();
		System.out.println(e1 - s1);

		long s2 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			list.contains("EEE");
		}
		long e2 = System.currentTimeMillis();
		System.out.println(e2 - s2);
	}
}
