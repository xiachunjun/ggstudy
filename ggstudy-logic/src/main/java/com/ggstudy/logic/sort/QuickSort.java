package com.ggstudy.logic.sort;

import java.util.Random;

/**
 * 快速排序
 * 
 * @author xcj
 *
 */
public class QuickSort {

	public static void main(String[] args) {

		int arrLength = 10;
		int[] arr = new int[arrLength];
		for (int i = 0; i < arrLength; i++) {
			arr[i] = new Random().nextInt(10 * arrLength);
		}

		arr = new int[] { 5, 1, 4, 6, 9, 2, 2, 7, 3, 0 };

		quickSort(arr, 0, arr.length - 1);
		for (int val : arr) {
			System.out.print(val + " ");
		}

	}

	public static void quickSort(int[] arr, int _left, int _right) {
		int left = _left;
		int right = _right;
		int standard = arr[left];// 以第一个值为标准值
		if (left < right) {
			while (left < right) {// 循环体中right在自减，left在自增最终会相等而结束循环
				while (left < right && arr[right] >= standard) {// 从right开始找比标准值小的
					--right;
				}
				arr[left] = arr[right];// 右边找到的第一个比标准值小的值，放到left的位置
				while (left < right && arr[left] <= standard) {// 从left开始找比标准值大的
					++left;
				}
				arr[right] = arr[left];// 左边找到了第一个比标准值大的，放到right
				// 如果left还没等于right，继续循环
			}
			arr[left] = standard;// 标准值归位。因为此时left==right，所以也可写成arr[right] =
									// standard;
			quickSort(arr, _left, left - 1);
			quickSort(arr, left + 1, _right);
		}
	}

}
