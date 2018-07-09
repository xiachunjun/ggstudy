package com.ggstudy.service.user.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ggstudy.common.GGException;
import com.ggstudy.dao.user.UserDomainMapper;
import com.ggstudy.domain.user.UserDomain;
import com.ggstudy.service.user.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private UserDomainMapper userDomainMapper;

	public UserDomain addUser(UserDomain user) throws GGException {
		try {
			userDomainMapper.insert(user);
			System.out.println(user.getUserId());
		} catch (Exception e) {
			throw new GGException("新增用户异常", e);
		}
		return null;
	}


}
