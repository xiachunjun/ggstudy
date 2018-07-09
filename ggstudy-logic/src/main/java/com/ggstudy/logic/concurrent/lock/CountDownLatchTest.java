package com.ggstudy.logic.concurrent.lock;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xcj
 */
public class CountDownLatchTest {
	public static int a = 0;

	public static void main(String[] args) {
		ExecutorService pool = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		CompletionService<String> completionService = new ExecutorCompletionService<String>(pool);
		int nThread = 5;
		CountDownLatch cdl = new CountDownLatch(nThread);
		for (int i = 0; i < nThread; i++) {
			completionService.submit(new AddCallable(String.valueOf(i), cdl));
		}
		try {
			Thread.sleep(4000);
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} 
		if (cdl.getCount() == 0L) {
			Future<String> future = null;
			while ((future = completionService.poll()) != null) {
				try {
					String response = future.get();
					System.out.println(response);
				} catch (InterruptedException | ExecutionException e) {
					System.out.println("future里面出的异常会在调future.get()时候抛出：" + e.getMessage());
				} finally {

				}
			}
		} else {
			// sleep了4秒，还没变成0，超时了，处理超时逻辑，该回退的回退，该丢弃的丢弃
			throw new RuntimeException("超时了。。。。。。。。。。");
		}
		pool.shutdown();
		System.out.println(a);
	}

	static class AddCallable implements Callable<String> {
		private String addCallableName;
		private CountDownLatch countDownLatch;

		public AddCallable(String addCallableName, CountDownLatch countDownLatch) {
			this.addCallableName = addCallableName;
			this.countDownLatch = countDownLatch;
		}

		@Override
		public String call() throws Exception {
			try {
				System.out.println("addCallableName:" + addCallableName);
				for (int i = 0; i < 1000; i++) {
					a++;
				}
				if ("2".equals(addCallableName)) {
					Thread.sleep(1000);
					throw new RuntimeException("22222222");
				}
			} catch (Exception e) {
				throw e;
			} finally {
				countDownLatch.countDown();
			}
			return addCallableName;
		}

	}
}
