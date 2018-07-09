package com.ggstudy.redis.demo;

import java.util.Random;

import org.junit.Test;

import redis.clients.jedis.Transaction;

public class SynchronizeLockDemo2 extends BaseDemo {
	// 加锁标志
	public static final String LOCKED = "TRUE";
	public static final long ONE_MILLI_NANOS = 1000000L;
	// 默认超时时间（毫秒）
	public static final long DEFAULT_TIME_OUT = 3000;
	public static final Random r = new Random();
	// 锁的超时时间（秒），过期删除
	public static final int EXPIRE = 5 * 60;
	private static String LOCK_KEY="XIAXIA";
	// 锁状态标志
	private boolean locked = false;

	/**
	 * @param timeout
	 * @return true表示获取锁成功，false表示获取锁失败
	 */
	public boolean lock(long timeout) {
        long nano = System.nanoTime();
        timeout *= ONE_MILLI_NANOS;
        try {
            while ((System.nanoTime() - nano) < timeout) {
                Transaction t = jedis.multi();
                // 开启事务，当server端收到multi指令
                // 会将该client的命令放入一个队列，然后依次执行，知道收到exec指令
                t.getSet(LOCK_KEY, LOCKED);
                String ret = (String) t.exec().get(0);
                if (ret == null || ret.equals("UNLOCK")) {
                	t.expire(LOCK_KEY, EXPIRE);
                    return true;
                }
                // 短暂休眠，nano避免出现活锁
                Thread.sleep(3, r.nextInt(500));
            }
        } catch (Exception e) {
        }
        return false;
    }
	@Test
	public void lock() {
		System.out.println(lock(DEFAULT_TIME_OUT));
	}

	// 无论是否加锁成功，必须调用
	@Test
	public void unlock() {
		if (!locked)
			jedis.del(LOCK_KEY);
	}
}
