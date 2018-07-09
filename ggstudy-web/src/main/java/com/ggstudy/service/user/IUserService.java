package com.ggstudy.service.user;

import com.ggstudy.common.GGException;
import com.ggstudy.domain.user.UserDomain;

/**
 * @author chad    530048777@qq.com
 * 接口定义时尽量定义抛出自定义异常，作用有两个：
 * 1、是封装了异常可以对外响应更友好的异常信息
 * 2、封装的异常本身是继承自RuntimeException,接口方法中强制这样的异常声明，可以使得实现时如果有异常需要抛出，必须被封装成自定义异常，同时事务也会被回滚
 * 注：不是没考虑到这种情况：需要抛出异常，但是事务不回滚。我觉得这种情况不存在，对于系统而言如果响应异常结果，事务就必然回滚。（个人观点，有异议可沟通）,这类需求大可以包装一个费异常结果返回
 */
public interface IUserService {
	public  UserDomain addUser(UserDomain user) throws GGException;
}
