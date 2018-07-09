package com.ggstudy.logic.java8new.interfaceTest;

/**
 * @author xcj
 * 
 *java8的接口可以有default方法
 *
 */
public interface InterfaceTest {

	void testMethod();
	
	default void sayInfo(String info){
		System.out.println("这里是default方法sayInfo："+info);
	}
	default void sayInfo1(String info){
		System.out.println("这里是default方法sayInfo1："+info);
	}
	
}
