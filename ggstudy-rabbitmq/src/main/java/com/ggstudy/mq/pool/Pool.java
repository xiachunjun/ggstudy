package com.ggstudy.mq.pool;

import java.io.Closeable;
import java.io.IOException;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class Pool<T> implements Closeable {
	protected GenericObjectPool<T> internalPool=null;

	@Override
	public void close() throws IOException {
		closeInternalPool();
		System.out.println(internalPool+"Pool.close().............");
	}

	public Pool(final GenericObjectPoolConfig poolConfig, PooledObjectFactory<T> factory) {
		initPool(poolConfig, factory);
	}

	/**
	 * 从池中拿对象
	 * 
	 * @return
	 */
	public T getResource() {
		try {
			System.out.println(internalPool.getBorrowedCount());
			return internalPool.borrowObject();
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException("Could not get a resource from the pool", e);
		}
	}
	
	
	/**
	 * 归还资源
	 * @param t
	 */
	public void returnResource(T t){
		internalPool.returnObject(t);
	}

	/**
	 * 初始化池
	 * 
	 * @param poolConfig
	 * @param factory
	 */
	public void initPool(final GenericObjectPoolConfig poolConfig, PooledObjectFactory<T> factory) {
		if (this.internalPool != null) {
			try {
				closeInternalPool();
			} catch (Exception e) {
			}
		}
		this.internalPool = new GenericObjectPool<T>(factory, poolConfig);
	}

	/**
	 * 关闭池
	 */
	protected void closeInternalPool() {
		if(internalPool==null){
			throw new RuntimeException("internalPool is null! Could not destroy the pool");
		}
		try {
			internalPool.close();
		} catch (Exception e) {
			throw new RuntimeException("Could not destroy the pool", e);
		}
	}
}
