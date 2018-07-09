package com.ggstudy.dao.user;

import com.ggstudy.dao.IBaseDao;
import com.ggstudy.domain.user.UserDomain;

import java.util.List;

public interface UserDomainMapper extends IBaseDao {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserDomain user);

    UserDomain selectByPrimaryKey(Integer userId);

    List<UserDomain> selectAll();

    int updateByPrimaryKey(UserDomain user);
}