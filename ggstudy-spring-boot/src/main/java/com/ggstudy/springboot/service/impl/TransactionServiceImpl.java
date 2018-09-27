package com.ggstudy.springboot.service.impl;

import com.ggstudy.springboot.dao.TransactionTestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
