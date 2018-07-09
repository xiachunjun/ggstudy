package com.ggstudy.logic.sort;

import java.util.Random;

/**
 * 冒泡排序
 * 
 * @author xcj
 *
 */
public class BubblingSort {
	public static void main(String[] args) {
		int arrLength = 10;
		int[] arr = new int[arrLength];
		for (int i = 0; i < arrLength; i++) {
			arr[i] = new Random().nextInt(10 * arrLength);
		}

		arr = new int[] { 5, 1, 4, 6, 9, 2, 2, 7, 3, 0 };
		bubblingSort1(arr);
//		bubblingSort(arr);
		for (int val : arr) {
			System.out.print(val + " ");
		}
	}

	/**
	 * 不够优雅的实现，哪怕第一次就排好了，也会执行arr.length - 1次
	 * @param arr
	 */
	public static void bubblingSort(int[] arr) {
		if (arr.length > 0) {
			int tmp = 0;
			for (int i = 0; i < arr.length - 1; i++) {
				for (int j = 0; j < arr.length - 1; j++) {
					if (arr[j] > arr[j + 1]) {//如果相邻两个数，前面的大于后面的，那就调换一下位置
						tmp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = tmp;
					}
				}
			}
		}
	}

	/**
	 * 在发生交换时flag会被置为true，会进行下次循环；否则就结束了
	 * 
	 * @param arr
	 */
	public static void bubblingSort1(int[] arr) {
		if (arr.length > 0) {
			boolean flag = true;
			while (flag) {
				flag = false;
				int tmp = 0;
				for (int i = 0; i < arr.length - 1; i++) {
					if (arr[i] > arr[i + 1]) {
						tmp=arr[i];
						arr[i] = arr[i + 1];
						arr[i + 1] = tmp;
						flag = true;
					}
				}

			}
		}

	}
}
