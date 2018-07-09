package com.ggstudy.logic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxTest implements InvocationHandler {

	private Object target;

	public Object getInstance(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		System.out.println("调用前。。。。。。。。。。");
		result = method.invoke(target, args);
		System.out.println("调用后。。。。。。。。。。");
		return result;
	}

	
	public static void main(String[] args) {
		JDKProxTest jdkproxTest=new JDKProxTest();
		IBook bookProxy=(IBook) jdkproxTest.getInstance(new BookImpl());
		((IBook2)bookProxy).addBook2("aaa");
		
	}
}
