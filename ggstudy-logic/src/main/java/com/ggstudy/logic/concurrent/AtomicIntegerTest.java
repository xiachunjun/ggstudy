package com.ggstudy.logic.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xcj
 * 基于CAS
 */
public class AtomicIntegerTest {
	static AtomicInteger ai = new AtomicInteger();
	public static void main(String[] args) {
		ExecutorService cachedThreadPool = new ThreadPoolExecutor(5, 10, 2L, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(10));
		for (int i = 0; i < 10; i++) {
			cachedThreadPool.submit(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 1000; j++) {
						ai.getAndIncrement();
					}
				}
			});
		}
		try {
			Thread.sleep(10000);
			System.out.println(ai);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
