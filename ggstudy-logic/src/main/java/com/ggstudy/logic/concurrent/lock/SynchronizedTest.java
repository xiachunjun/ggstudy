package com.ggstudy.logic.concurrent.lock;

public class SynchronizedTest {
	public static final Object objA = new Object();
	public static final Object objB = new Object();

	public static void main(String[] args) {
		DieLockMain();// 死锁演示
	}

	public static void DieLockMain() {
		Thread die1 = new DieLock(true);
		Thread die2 = new DieLock(false);
		die1.start();
		die2.start();
	}

	static class DieLock extends Thread {
		private boolean flag;

		public DieLock(boolean flag) {
			this.flag = flag;
		}

		@Override
		public void run() {
			if (flag) {
				synchronized (SynchronizedTest.objA) {
					System.out.println("if objA");
					synchronized (SynchronizedTest.objB) {
						System.out.println("if objB");
					}
				}
			} else {
				synchronized (SynchronizedTest.objB) {
					System.out.println("else objB");
					synchronized (SynchronizedTest.objA) {
						System.out.println("else objA");
					}
				}
			}
		}
	}
}
