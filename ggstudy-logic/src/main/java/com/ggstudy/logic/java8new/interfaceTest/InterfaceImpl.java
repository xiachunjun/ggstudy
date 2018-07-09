package com.ggstudy.logic.java8new.interfaceTest;

public class InterfaceImpl implements InterfaceTest {

	@Override
	public void testMethod() {
		System.out.println("这里是testMethod方法");
	}

	public static void main(String[] args) {
		InterfaceTest it = new InterfaceImpl();
		it.sayInfo("啊哈哈哈哈");
		it.sayInfo1("啊哈哈哈哈1");
		it.testMethod();
	}
}
