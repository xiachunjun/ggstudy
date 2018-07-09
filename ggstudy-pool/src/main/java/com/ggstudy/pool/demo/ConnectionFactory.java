package com.ggstudy.pool.demo;

import org.apache.commons.pool2.BaseKeyedPooledObjectFactory;
import org.apache.commons.pool2.KeyedObjectPool;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericKeyedObjectPool;

public class ConnectionFactory extends BaseKeyedPooledObjectFactory<String, Connection> {

	@Override
	public Connection create(String key) throws Exception {
		// TODO Auto-generated method stub
		return new Connection();
	}

	@Override
	public PooledObject<Connection> wrap(Connection value) {
		return new DefaultPooledObject<Connection>(value);
	}

	public static void main(String[] args) {
		KeyedObjectPool<String, Connection> objectPool = new GenericKeyedObjectPool<String, Connection>(new ConnectionFactory());
		try {
			// 添加对象到池，重复的不会重复入池
			objectPool.addObject("1");
			objectPool.addObject("2");
			objectPool.addObject("3");

			// 获得对应key的对象
			Connection Connection1 = objectPool.borrowObject("1");
			System.out.println(Connection1);
			// 释放对象
			//objectPool.returnObject("1", Connection1);
			
			Connection Connection2= objectPool.borrowObject("1");
			System.out.println(Connection2);

			// 清除所有的对象
			objectPool.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}
