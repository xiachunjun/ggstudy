package com.ggstudy.springboot.controller;

import com.ggstudy.springboot.domain.User;
import com.ggstudy.springboot.model.UserReq;
import com.ggstudy.springboot.service.IUserService;
import com.ggstudy.springboot.service.impl.TransactionServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CRUDController {

    @Autowired
    IUserService userService;

    @Autowired
    TransactionServiceImpl transactionServiceImpl;

    @RequestMapping("/crud/create")
    public void create(@RequestBody UserReq userReq) {
        User u = new User();
        BeanUtils.copyProperties(userReq, u);
        userService.addUser(u);
    }

    @RequestMapping("/crud/read")
    public List<User> read() {
        return userService.queryAll();
    }

    @RequestMapping("/crud/update")
    public void update() {

    }

    @RequestMapping("/crud/delete")
    public void delete() {

    }

    @RequestMapping("/crud/transactionTest")
    public void transactionTest(String msg){
        transactionServiceImpl.updateTwoTab(msg);
    }

}
