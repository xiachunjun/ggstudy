package com.ggstudy.springboot.service.impl;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ggstudy.springboot.domain.User;
import com.ggstudy.springboot.mapper.db2.UserMapper;
import com.ggstudy.springboot.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {


	@Autowired
	UserMapper userMapper;


	ExecutorService es= Executors.newFixedThreadPool(5); ;

	@Transactional(transactionManager = "transactionManager2", propagation = Propagation.REQUIRED)
	@Override
	public void addUser(User user) {
		try {
			userMapper.insert(user);
			User aa = userMapper.selectByPrimaryKey(user.getId());
			System.out.println(aa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			// throw new RuntimeException();
		}
	}

    @Override
    public void updateUserAsyc(User user) {
        es.execute(()->updateUser(user));
    }


	@Override
	public void updateUser(User user) {

        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            int i = userMapper.updateByPrimaryKey(user);
            System.out.println(this);
            i = 1 / 0;
        }catch (Exception e1){
            throw  e1;
        }

    }

    @Override
    public List<User> queryAll(){
        return userMapper.selectAll();
    }
}
