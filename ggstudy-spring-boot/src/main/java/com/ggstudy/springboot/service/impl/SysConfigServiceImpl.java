package com.ggstudy.springboot.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ggstudy.springboot.domain.SysConfig;
import com.ggstudy.springboot.domain.User;
import com.ggstudy.springboot.mapper.db1.SysConfigMapper;
import com.ggstudy.springboot.service.ISysConfigService;
import com.ggstudy.springboot.service.IUserService;
import com.ggstudy.springboot.support.AppLogger;

@Service
public class SysConfigServiceImpl implements ISysConfigService {

	@Autowired
	SysConfigMapper sysConfigMapper;

	@Autowired
	IUserService userService;

	public void addSysConfig(SysConfig sc) {
		AppLogger.info(this, "SysConfigServiceImpl.addSysConfig==");
		AppLogger.logJson(this, "SysConfigServiceImpl.addSysConfig==", sc);
		try {
			sysConfigMapper.insert(sc);
		} catch (Exception e) {
			AppLogger.error(this, "SysConfigServiceImpl.addSysConfig====", e);
		}
	}

	@Transactional(transactionManager="transactionManager1",propagation = Propagation.REQUIRED)
	@Override
	public void updateSysConfig(SysConfig sc) {
		User user = new User();
		user.setId(1);
		user.setUserName("2222");
		userService.updateUser(user);
		System.out.println(sc.getCfgName());
		int i = sysConfigMapper.updateByPrimaryKey(sc);
		throw new RuntimeException("2222222222222");
	}

	@Override
	public SysConfig getSysConfig(Integer id) {
		SysConfig sys = sysConfigMapper.selectByPrimaryKey(id);
		return sys;
	}

	@Override
	public List<String> asyncTest() {
		List<String> resList=new ArrayList<String>();
		List<Future<String>> list=new ArrayList<Future<String>>();
		for (int i = 0; i < 50; i++) {
			list.add(async(i));
		}
		int aa=0;
		while(list.size()>0){
			Iterator<Future<String>> it=list.iterator();
			while(it.hasNext()){
				Future<String> fu=it.next();
				if(fu.isDone()){
					System.out.println(aa++);
					try {
						resList.add(fu.get());
					} catch (Exception e) {
						e.printStackTrace();
					} 
					it.remove();
				}
				
			}
			try {
				System.out.println(aa++);
				Thread.sleep(100);//主动休眠一会儿
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		return resList;
		
	}

	@Async
	public Future<String> async(int i) {
		AsyncResult<String> ar = new AsyncResult<>(i + "====" + Thread.currentThread().toString());
		try {
			Thread.sleep(500);//主动休眠一会儿
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ar;
	}
}
