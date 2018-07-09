package com.ggstudy.logic.concurrent.lock;

import java.util.concurrent.CountDownLatch;

public class LockTest {

	public static void main(String[] args) {
		CountDownLatch cdl=new CountDownLatch(0);
		cdl.countDown();
		System.out.println(cdl.getCount());
	}



}
