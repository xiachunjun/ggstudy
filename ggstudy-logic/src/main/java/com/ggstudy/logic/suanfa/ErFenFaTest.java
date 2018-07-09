package com.ggstudy.logic.suanfa;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xcj 二分法测试
 */
public class ErFenFaTest {
	public static void main1(String[] args) {
		System.out.println(7 & 2);// 与
		System.out.println(7 | 2);// 或
		System.out.println(7 ^ 2);// 非
	}

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}

		int start = 0;
		int end = list.size() - 1;
		Integer needFind = 2;
		int times = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (needFind < list.get(mid)) {
				end = mid - 1;
			} else if (needFind > list.get(mid)) {
				start = mid + 1;
			} else {
				System.out.println("第" + (++times) + "次");
				System.out.println(list.get(mid));
				return;
			}
			++times;
		}
		System.out.println(times+"次，没找到");
	}

}
