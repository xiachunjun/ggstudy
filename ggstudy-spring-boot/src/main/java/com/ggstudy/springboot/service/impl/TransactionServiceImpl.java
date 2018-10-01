package com.ggstudy.springboot.service.impl;

import com.ggstudy.springboot.dao.TransactionTestDao;
import com.ggstudy.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionServiceImpl {

    @Autowired
    TransactionTestDao transactionTestDao;
    @Autowired
    IUserService userService;

    @Transactional(transactionManager = "transactionManager2")
    public void updateTwoTab(String msg){
        transactionTestDao.insertUser(msg);
        transactionTestDao.insertUserCopy(msg);
        throw  new RuntimeException();
    }


    @Transactional(transactionManager = "transactionManager2")
    public void service内部调用事务测试(String msg){
        this.updateUser(msg);
        this.updateCopyUser(msg);
        userService.addUser(null);
//        throw  new RuntimeException();
    }

    public void updateUser(String msg){
        transactionTestDao.insertUser(msg);
//        throw  new RuntimeException();
    }

    public void updateCopyUser(String msg){
        transactionTestDao.insertUserCopy(msg);
//        throw  new RuntimeException();
    }


}
