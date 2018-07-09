package com.ggstudy.springboot.service;

import java.util.List;

import com.ggstudy.springboot.domain.SysConfig;

public interface ISysConfigService {

	SysConfig getSysConfig(Integer id);

	void addSysConfig(SysConfig sc);

	void updateSysConfig(SysConfig sc);

	/**
	 * 测试异步调用的
	 * 
	 * @param i
	 * @return 
	 */
	List<String> asyncTest();
	
	default void sys(){
		System.out.println(111);
	}
}
