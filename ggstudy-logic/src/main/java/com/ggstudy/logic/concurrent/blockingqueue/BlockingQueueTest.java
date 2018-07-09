package com.ggstudy.logic.concurrent.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest {
	// ArrayBlockingQueue
	// DelayQueue
	// LinkedBlockingQueue
	// PriorityBlockingQueue
	// SynchronousQueue

	public static void main(String[] args) {
		arrayBlockingQueueTest();
	}

	public static void arrayBlockingQueueTest() {
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(10);

		bq.add("ssss1");
		bq.add("ssss2");
		bq.add("ssss3");
		System.out.println(bq.poll());
		System.out.println(bq.poll());
		System.out.println(bq.poll());
		Runnable r = new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				bq.add("ssss4");
				// TODO Auto-generated method stub

			}
		};
		new Thread(r).start();
		try {
			System.out.println(bq.poll(5000, TimeUnit.MILLISECONDS));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
