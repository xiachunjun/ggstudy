package com.ggstudy.trans.service.proxy;

import com.ggstudy.trans.domain.Trans;
import com.ggstudy.trans.domain.TransB;
import com.ggstudy.trans.mapper.TransBMapper;
import com.ggstudy.trans.mapper.TransMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;

@Service
public class TransServiceImpl implements ITransService {

    private TransMapper transMapper;

    @Autowired
    private TransBMapper transBMapper;

    @Autowired
    ITransBService transBService;

    @Autowired
    public TransServiceImpl(TransMapper transMapper) {
        this.transMapper = transMapper;
    }


    @Override
    public boolean insertTrans(Trans trans) {
        Objects.requireNonNull(trans, "trans不能为null");
        trans.setCreateTime(new Date());
        trans.setUpdateTime(trans.getCreateTime());
        int i = transMapper.insert(trans);

        TransB transB = new TransB();
        BeanUtils.copyProperties(trans, transB);
        this.insertTransB(transB);

        return i == 1;
    }

    @Transactional
    @Override
    public boolean insertTransB(TransB transB) {
        Objects.requireNonNull(transB, "transB不能为null");
//        transB.setCreateTime(new Date());
//        transB.setUpdateTime(transB.getCreateTime());
        int j = transBMapper.insert(transB);
        int a = 1 / 0;
        return j == 1;
    }


}
