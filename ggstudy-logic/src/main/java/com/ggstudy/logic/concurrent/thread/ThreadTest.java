package com.ggstudy.logic.concurrent.thread;

/**
 * @author xcj 线程两种方式，继承Thread，实现
 */
public class ThreadTest {
	public static volatile int num = 0;

	public static void main(String[] args) {
//		test1();// 并发问题测试
		test2();//Interrupt测试
	}

	// 并发问题测试
	public static void test1() {
		Thread mt1 = new MyThread();
		Thread mt2 = new MyThread();
		Thread mt3 = new Thread(new MyRunable());
		Thread mt4 = new Thread(new MyRunable());
		mt1.start();
		mt2.start();
		mt3.start();
		mt4.start();
		try {
			Thread.sleep(10000);
			System.out.println(num);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Interrupt测试
	 */
	public static void test2() {
		Thread it = new InterruptThread();
		try {
			it.start();
			Thread.sleep(1000);
			it.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/// ===============一下是线程类=================////////
	static class MyThread extends Thread {
		@Override
		public void run() {
			synchronized (ThreadTest.class) {// 如果不加同步，就是典型的同步问题
				for (int i = 0; i < 1000; i++) {
					try {
						Thread.sleep(1);
						num++;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	static class MyRunable implements Runnable {

		@Override
		public void run() {
			synchronized (ThreadTest.class) {// 如果不加同步，就是典型的同步问题
				for (int i = 0; i < 1000; i++) {
					try {
						Thread.sleep(1);
						num++;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	static class InterruptThread extends Thread {
		@Override
		public void run() {
			while (isInterrupted()) {
				System.out.println("..........");
				System.out.println("终止状态是：" + isInterrupted());
			}
		}
	}
}
