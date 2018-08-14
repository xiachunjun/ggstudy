package com.ggstudy.logic.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		MapTest mt= new MapTest();
//		mt.HashMapTest();
//		System.gc();
//		System.out.println(11);
//		Integer a=new Integer(1000);
//		System.out.println(1000==a);

//		mt.mapSizeTest();
//		System.out.println(Integer.MAX_VALUE);
		System.out.println(222^(222 >>> 16));

		Integer a=new Integer(1);
		Integer b=new Integer(1);
		System.out.println(a==b);
	}



	public void mapSizeTest(){
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("11","11");
		Set<Integer> set=new HashSet<>(10);
		for(int i=0;i<10;i++){
			set.add(i);
		}

		System.out.println(set.size());
		for(int i=0;i<10;i++){
			set.remove(i);
		}
		System.out.println(set.size());




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
