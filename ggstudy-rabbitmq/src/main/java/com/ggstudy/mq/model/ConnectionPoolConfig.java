package com.ggstudy.mq.model;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class ConnectionPoolConfig extends GenericObjectPoolConfig {
	
	
  public ConnectionPoolConfig() {
    // defaults to make your life with connection pool easier :)
    setTestWhileIdle(true);
    setMinEvictableIdleTimeMillis(60000);
    setTimeBetweenEvictionRunsMillis(30000);
    setNumTestsPerEvictionRun(-1);
    setMaxTotal(10);
  }
}