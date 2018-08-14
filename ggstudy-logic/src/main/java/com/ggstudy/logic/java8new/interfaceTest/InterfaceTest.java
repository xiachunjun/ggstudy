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
	class ArrivalNormal {

		// 50000-60000 表示到店服务
		private static final int Base = 50000;

		/**
		 * 到店自取模式
		 */
		public static class SelfRule {
			private static final int Base = 51000;
			// 正常结算
			public static final int NormalSettle = Base + 1;
			// 正常无效
			public static final int NormalInvalid = Base + 2;
		}
	}
}
