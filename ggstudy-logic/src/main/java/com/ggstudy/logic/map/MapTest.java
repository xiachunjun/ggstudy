package com.ggstudy.logic.map;

import java.util.HashMap;

public class MapTest {
	public static void main(String[] args) {
		MapTest mt= new MapTest();
		mt.HashMapTest();
		System.gc();
		System.out.println(11);
//		Integer a=new Integer(1000);
//		System.out.println(1000==a);
	}
	
	
	public void HashMapTest() {
		MapKey mk1=new MapKey();
		mk1.setName("111111111");
		MapKey mk2=new MapKey();
		mk2.setName("222222222");
		MapKey mk3=new MapKey();
		mk2.setName("333333333");
		
		HashMap<MapKey, String> hashMap = new HashMap<>();
		hashMap.put(mk1,"1111");
		hashMap.put(mk2,"2222");
		hashMap.put(mk3,"3333");
		System.out.println(hashMap.get(mk2));
		System.out.println(hashMap);
		
		
	}
	
	class MapKey{

		private String name;
		
		@Override
		public int hashCode() {
			return 1111;
		}

		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return super.equals(obj);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
}
