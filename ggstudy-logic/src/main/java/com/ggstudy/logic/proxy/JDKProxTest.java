package com.ggstudy.logic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxTest{

	public static void main(String[] args) {
		MyProxy jdkproxTest=new MyProxy();
		IBook bookProxy=(IBook) jdkproxTest.getInstance(new BookImpl());
		bookProxy.addBook("222");
//		((IBook2)bookProxy).addBook2("aaa");
		
	}
}
