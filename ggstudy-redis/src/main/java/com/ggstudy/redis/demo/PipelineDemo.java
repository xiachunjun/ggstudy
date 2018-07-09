package com.ggstudy.redis.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

/**
 * @author Administrator
 *  管道命令，一次执行多条指令
 */
public class PipelineDemo extends BaseDemo {

	@Test
	public void PipelineTest() {
		List<Response<String>> strList = new ArrayList<Response<String>>();
		Pipeline pl = jedis.pipelined();
		for (int i = 0; i < 1000; i++) {
			pl.set("" + i, i + "aaaaa");
		}
		for (int i = 0; i < 1000; i++) {
			strList.add(pl.get("" + i));
		}
		pl.sync();
		try {
			pl.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Response<String> r : strList) {// 使用之前要先关闭管道
			System.out.println(r.get());
		}
	}

	public void ttttt() {
		Map<String, String> data = new HashMap<String, String>();
		jedis.select(8);
		jedis.flushDB();
		// hmset
		long start = System.currentTimeMillis();
		// 直接hmset
		for (int i = 0; i < 10000; i++) {
			data.clear();
			data.put("k_" + i, "v_" + i);
			jedis.hmset("key_" + i, data);
		}
		long end = System.currentTimeMillis();
		System.out.println("dbsize:[" + jedis.dbSize() + "] .. ");
		System.out.println("hmset不使用管道时间消耗 [" + (end - start) + "]  ..");
		jedis.select(8);
		jedis.flushDB();
		// 使用pipeline hmset
		Pipeline p = jedis.pipelined();
		start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			data.clear();
			data.put("k_" + i, "v_" + i);
			p.hmset("key_" + i, data);
		}
		p.sync();
		end = System.currentTimeMillis();
		System.out.println("dbsize:[" + jedis.dbSize() + "] .. ");
		System.out.println("hmset使用管道时间消耗 [" + (end - start) + "] ..");

		// hmget
		Set<String> keys = jedis.keys("*");
		// 直接使用Jedis hgetall
		start = System.currentTimeMillis();
		Map<String, Map<String, String>> result = new HashMap<String, Map<String, String>>();
		for (String key : keys) {
			result.put(key, jedis.hgetAll(key));
		}
		end = System.currentTimeMillis();
		System.out.println("result size:[" + result.size() + "] ..");
		System.out.println("hgetAll不使用管道时间消耗[" + (end - start) + "] ..");

		// 使用pipeline hgetall
		Map<String, Response<Map<String, String>>> responses = new HashMap<String, Response<Map<String, String>>>(keys.size());
		result.clear();
		start = System.currentTimeMillis();
		for (String key : keys) {
			responses.put(key, p.hgetAll(key));
		}
		p.sync();
		for (String k : responses.keySet()) {
			result.put(k, responses.get(k).get());
		}
		end = System.currentTimeMillis();
		System.out.println("result size:[" + result.size() + "] ..");
		System.out.println("hgetAll使用管道时间消耗 [" + (end - start) + "] ..");
	}

}
