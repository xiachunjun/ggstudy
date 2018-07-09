package com.ggstudy.mq.model;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class ChannelPoolConfig extends GenericObjectPoolConfig {
	
	
  public ChannelPoolConfig() {
    // defaults to make your life with connection pool easier :)
    setTestWhileIdle(true);
    setMinEvictableIdleTimeMillis(60000);
    setTimeBetweenEvictionRunsMillis(30000);
    setNumTestsPerEvictionRun(-1);
    setMaxTotal(10);
  }
}