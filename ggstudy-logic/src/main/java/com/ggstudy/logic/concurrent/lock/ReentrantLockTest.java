package com.ggstudy.logic.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

	public static int tickets = 0;
	public static Lock lock = new ReentrantLock();
	public static Condition con = lock.newCondition();

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new LockThread("name" + i).start();
		}
	}

	static class LockThread extends Thread {
		private String name;

		public LockThread(String name) {
			super(name);
			this.name = name;
		}

		@Override
		public void run() {
			try {
				lock.lock();
				for (int i = 0; i < 100; i++) {
					tickets++;
					System.out.println(tickets);
				}
				System.out.println(name);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
			System.out.println(lock.toString());
		}

	}
}
