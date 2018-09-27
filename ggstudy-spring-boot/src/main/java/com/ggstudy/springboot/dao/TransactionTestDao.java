package com.ggstudy.springboot.dao;

import com.ggstudy.springboot.domain.User;
import com.ggstudy.springboot.mapper.db2.UserCopyMapper;
import com.ggstudy.springboot.mapper.db2.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionTestDao {
    @Autowired
    UserCopyMapper userCopyMapper;

    @Autowired
    UserMapper userMapper;


    public void insertUser(String msg){
        User user=new User();
        user.setUserName(msg);
        userMapper.insert(user);
    }

    public void insertUserCopy(String msg){
        User user=new User();
        user.setUserName(msg);
        userCopyMapper.insert(user);
    }


}
