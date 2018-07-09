package com.ggstudy;

import java.util.ArrayList;
import java.util.List;


public class C {
	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
       
	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		List<C> strList=new ArrayList<C>();
		C c1=new C();
		c1.setId(1);
		c1.setName("张三");
		
		C c2=new C();
		c2.setId(2);
		c2.setName("李四");
		
		
		C c3=new C();
		c3.setId(3);
		c3.setName("王五");
		
		C c4=new C();
		c4.setId(4);
		c4.setName("李四");
		
		strList.add(c1);
		strList.add(c2);
		strList.add(c3);
		
		
		C c = strList.stream().filter(bean -> "李四1".equals(bean.getName())).findFirst().orElseGet(null);
		System.out.println(c.getId());
		
	
	}
}
