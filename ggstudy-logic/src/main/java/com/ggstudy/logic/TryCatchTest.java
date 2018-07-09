package com.ggstudy.logic;

public class TryCatchTest {
	public static void main(String[] args) {
		System.out.println(new TryCatchTest().add());
		System.out.println(test11());
	}

	public int add() {
		int i = 0;
		try {
			return i;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			++i;
		}
		return 100;
	}

	public static String test11() {
		try {
			System.out.println("try block");
			return test12();
		} finally {
			System.out.println("finally block");
		}
	}

	public static String test12() {
		System.out.println("return statement");

		return "after return";
	}

}
