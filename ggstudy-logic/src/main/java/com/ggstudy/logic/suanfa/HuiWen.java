package com.ggstudy.logic.suanfa;

public class HuiWen {

	public static String str = "12344321abcddcba1234dcbaabcd4311111111";

	public static void main(String[] args) {
		reStr(8, str);
	}

	public static void reStr(int n, String str) {
		int start = 0;
		int end = start + n;
		if (end > str.length()) {
			return;
		}
		while (end <= str.length()) {
			String line = str.substring(start, end);
			if (line.equals(new StringBuilder(line).reverse().toString())) {
				System.out.println(line);
			}
			start++;
			end++;
		}
		reStr(++n, str);
	}

}
