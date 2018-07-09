package com.ggstudy.logic.sort;

import java.util.Random;

public class InsertSort {
	public static void main(String[] args) {
		int arrLength = 10;
		int[] arr = new int[arrLength];
		for (int i = 0; i < arrLength; i++) {
			arr[i] = new Random().nextInt(10 * arrLength);
		}

		arr = new int[] { 5, 1, 4, 6, 9, 2, 2, 7, 3, 0 };
		insertSort(arr);
		for (int val : arr) {
			System.out.print(val + " ");
		}
	}
	
	public static void insertSort(int[] arr){
		if(arr.length>0){
//			for(){
//				
//			}
		}
	}
}
