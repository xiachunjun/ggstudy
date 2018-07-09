package com.ggstudy.springboot.service.impl;

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

	@Transactional(transactionManager = "transactionManager2", propagation = Propagation.REQUIRED)
	@Override
	public void updateUser(User user) {

		try {
			int i = userMapper.updateByPrimaryKey(user);

			System.out.println(i / 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
