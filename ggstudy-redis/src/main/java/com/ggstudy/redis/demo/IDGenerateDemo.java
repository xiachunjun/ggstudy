package com.ggstudy.redis.demo;

import java.sql.Time;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.ggstudy.redis.pool.JedisUtil;

import redis.clients.jedis.Jedis;

/**
 * @author Administrator redis服务端是单线程的，所以直接用incr就行了
 * 
 */
public class IDGenerateDemo extends BaseDemo {
	@Test
	public void getNextId() {
		for (int i = 0; i < 100; i++) {
			System.out.println(jedis.incr("id1"));

		}
	}

	public static void main(String[] args) {
		JedisUtil jedisUtil = JedisUtil.getJedisUtil();
		ExecutorService pool = new ThreadPoolExecutor(5, 5, 30, TimeUnit.SECONDS,
				new LinkedBlockingDeque<Runnable>());
		CompletionService<Long> completionService = new ExecutorCompletionService<Long>(pool);
		int nThread = 10;
		for (int i = 0; i < nThread; i++) {
			completionService.submit(new Callable<Long>() {
				Jedis jedis=jedisUtil.getJedis();
				@Override
				public Long call() throws Exception {
					for (int j = 0; j < 99; j++) {
						jedis.incr("qwqw3");
					}
					return jedis.incr("qwqw3");
				}
			});
		}
		
		long timeLimit = System.currentTimeMillis() + 10000;
		while (nThread > 0) {
			if (System.currentTimeMillis() > timeLimit) {
				pool.shutdown();
				throw new RuntimeException("time_out");
			}
			Future<Long> future = completionService.poll();
			if (future != null) {
				try {
					Long response = future.get();
					System.out.println(response);
				} catch (InterruptedException | ExecutionException e) {
					System.out.println(e);
					throw new RuntimeException("time_out.......");
				} finally {
					nThread--;
				}
			}
		}
//		jedis.close();
		// pool.shutdown();

	}
}
