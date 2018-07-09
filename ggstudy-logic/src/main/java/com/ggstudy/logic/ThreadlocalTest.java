package com.ggstudy.logic;

public class ThreadlocalTest {

	public static void main(String[] args) {

		ThreadLocal<String> tl = new ThreadLocal<String>();

		for (int i = 0; i < 10; i++) {
			int j = i;
			Runnable t = new Runnable() {
				@Override
				public void run() {
					tl.set(("" + j));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(j + "-------" + tl.get());
				}
			};
			new Thread(t).start();
		}
	}

	public static Runnable test1() {
		return () -> {
			System.out.println(Thread.currentThread());
		};

	}
}
