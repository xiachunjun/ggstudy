package com.ggstudy.logic.sort;

import java.util.Random;

/**
 * 选择排序
 * 
 * @author xcj
 *
 */
public class SelctionSort {
	public static void main(String[] args) {
		int arrLength = 10;
		int[] arr = new int[arrLength];
		for (int i = 0; i < arrLength; i++) {
			arr[i] = new Random().nextInt(10 * arrLength);
		}

		arr = new int[] { 5, 1, 4, 6, 9, 2, 2, 7, 3, 0 };
		selctionSort(arr);
		for (int val : arr) {
			System.out.print(val + " ");
		}
	}

	/**
	 * i是外层循环标识，开始假设i是最小值的下标，然后j从i+1位开始，找到比arr[i]小的，就把最小值的下标minIndex记录下来，最后做替换
	 * * @param arr
	 */
	public static void selctionSort(int[] arr) {
		if (arr.length > 0) {
			for (int i = 0; i < arr.length - 1; i++) {
				int minIndex = i;
				for (int j = i + 1; j < arr.length - 1; j++) {
					if (arr[j] < arr[minIndex]) {
						minIndex = j;
					}
				}
				if (minIndex != i) {
					int tmp = arr[i];
					arr[i] = arr[minIndex];
					arr[minIndex] = tmp;
				}
			}
		}
	}
}
