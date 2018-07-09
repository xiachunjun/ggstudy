package com.ggstudy.logic.concurrent.thread;

import java.util.LinkedList;
import java.util.List;

public class ProducerAndConsumerTest {

	static List<Object> queue = new LinkedList<Object>();

	public static void main(String[] args) {
		ProducerAndConsumerTest outerObj = new ProducerAndConsumerTest();
		try {

			for (int i = 0; i < 5; i++) {
				outerObj.new Producer(queue).start();
			}
//			for (int i = 0; i < 3; i++) {
//				System.out.println("sleep。。。。" + i + "秒。。。。");
//				Thread.sleep(1000);
//			}
			for (int i = 0; i < 3; i++) {
				outerObj.new Consumer(queue).start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author xcj 生产者
	 */
	class Producer extends Thread {
		List<Object> queue;

		public Producer(List<Object> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			synchronized (this) {
				for (int i = 0; i < 10; i++) {
					System.out.println("Producer="+this);
					queue.add(this.getName() + "==>" + i);

				}
			}
		}
	}

	/**
	 * @author xcj 消费者
	 */
	class Consumer extends Thread {
		List<Object> queue;

		public Consumer(List<Object> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			synchronized (this) {
				while (queue.size() == 0) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				while (queue.size() > 0) {
					System.out.println("Consumer="+this);
					System.out.println(queue.remove(0));
				}
				this.notify();
			}
		}

	}
}
