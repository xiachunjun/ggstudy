package com.ggstudy.logic.concurrent;

public class VolatileTest {
	private volatile int n1 = 0;// volatile
	private int n2 = 0;

	public static void main(String[] a) {
		new VolatileTest().test();
	}

	public void test() {
		Thread t1 = new Thread() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (VolatileTest.class) {//加上同步才能判断
						System.out.println(n2);
						System.out.println(n1);
						if (n2 != n1) {
							System.out.println("n2!=n1");
							break;
						} else {
							continue;
						}
					}
				}
				
			}
			
		};
		Thread t2 = new Thread() {
			public void run() {
				for (; n1 < Integer.MAX_VALUE;) {
					synchronized (VolatileTest.class) {//加上同步才行
						++n1;
						++n2;
					}
				}
				System.out.println("stoped");
			}
		};
		t1.start();
		t2.start();
	}

}
