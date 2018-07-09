package com.ggstudy.logic.java8new;

import java.io.Serializable;
import java.util.Comparator;

import com.ggstudy.logic.java8new.interfaceTest.InterfaceImpl;
import com.ggstudy.logic.java8new.interfaceTest.InterfaceTest;

public class MainTest {
	public static void main(String[] args) {
		InterfaceTest it = new InterfaceImpl();
		it.sayInfo("啊哈哈哈哈");//接口的默认方法
		it.sayInfo1("啊哈哈哈哈1");//接口的默认方法
		
		it.testMethod();
	}
	 public String aaa(){
		 
		String a=  (String & Serializable)"";
		return a;
	 }

}
