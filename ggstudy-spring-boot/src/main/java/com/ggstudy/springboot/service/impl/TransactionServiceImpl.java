package com.ggstudy.springboot.service.impl;

import com.ggstudy.springboot.dao.TransactionTestDao;
import com.ggstudy.springboot.domain.SysConfig;
import com.ggstudy.springboot.domain.User;
import com.ggstudy.springboot.mapper.db1.SysConfigMapper;
import com.ggstudy.springboot.mapper.db2.UserCopyMapper;
import com.ggstudy.springboot.mapper.db2.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionServiceImpl {
    @Autowired
    TransactionTestDao transactionTestDao;


    @Transactional(transactionManager = "transactionManager2")
    public void updateTwoTab(String msg){
        transactionTestDao.insertUser(msg);
        transactionTestDao.insertUserCopy(msg);
        throw  new RuntimeException();
    }

}
