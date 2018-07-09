package com.ggstudy.logic;

public class OtherTest {
	public static void main(String[] args) {
		// 三元表达式自动提升类型();
//		tryCatchFinallyTest();
		stringTest();
	}

	/**
	 * i为null，提升到Double类型时，报错
	 */
	public static void 三元表达式自动提升类型() {
		Integer i = null;
		Double d = new Double(2.0);
		Object o = true ? i : d; // NullPointerException!
		System.out.println(o);

	}

	public static void tryCatchFinallyTest() {
		try {
			System.out.println(t());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int t() throws Exception {
		int i = 0;
		try {
			// i = 1 / 0;
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} finally {
			System.out.println(1);
			throw new RuntimeException("11111");
		}
	}

	public static void stringTest() {
		String str1 = "test";
		String str2 = "te" + "st";
		String str3 = str1 + "";
		String str4 = new String("test");
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		System.out.println(str1 == str4);
		System.out.println(str2 == str3);
		System.out.println(str1.equals(str2) );
		System.out.println(str1.equals(str3) );
		System.out.println(str2.equals(str3));

	}

}
