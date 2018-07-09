package com.ggstudy.logic.map;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
	public static void main(String[] args) {
		ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<String, String>();
		String ss=new String("sssss");
		chm.put(ss, "123e");
		System.out.println(chm.put(ss, "123e12"));
		System.out.println(chm.get(ss));
		// chm.put("123e12",null );//ConcurrentHashMap中key-value均不能为null
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("1213", "123e");
		hm.put("1213", "123e1");
		hm.put(null, null);
		hm.get("111111");

//		System.out.println(chm.get(new String("1213")));
//		System.out.println(new Integer(12).toString());
	}

}
