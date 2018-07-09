package com.ggstudy.logic.concurrent;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CallableAndFutureTest {

	public static void main(String[] args) {
		CallableAndFutureTest caf = new CallableAndFutureTest();
		caf.completionServiceTest();
	}

	public void completionServiceTest() {
		ExecutorService pool = new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(10));
		
		CompletionService<String> completionService = new ExecutorCompletionService<String>(pool);
		for (int i = 0; i < 10; i++) {
			Callable<String> c = new Callable<String>() {
				@Override
				public String call() throws Exception {
					Thread.sleep(new Random().nextInt(1000));
					String res = Thread.currentThread().getName() + "";
					return res;
				}
			};
			completionService.submit(c);
		}
		int num = 0;

		while (num < 10) {
			Future<String> f = completionService.poll();// 不会阻塞等待
			// Future<String> f=completionService.take();//会阻塞等待
			if (f != null) {
				try {
					String s = f.get();
					System.out.println(num + "===" + s);
					num++;
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		}
		
		pool.shutdown();
		
		boolean 丨=true;
		
		
		if(丨){
			//Java中让这段正常编译&运行^_^
		}
		
	}
	
	
}
