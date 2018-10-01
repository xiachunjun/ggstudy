package com.ggstudy.trans.service.proxy;

import com.ggstudy.trans.domain.Trans;
import com.ggstudy.trans.domain.TransB;
import com.ggstudy.trans.mapper.TransBMapper;
import com.ggstudy.trans.mapper.TransMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransServiceImpl implements ITransService {

    private TransMapper transMapper;

    private TransBMapper transBMapper;

    @Autowired
    public TransServiceImpl(TransMapper transMapper, TransBMapper transBMapper) {
        this.transMapper = transMapper;
        this.transBMapper = transBMapper;
    }

    @Override
    public boolean insertTrans(Trans trans) {
        return 1 == transMapper.insert(trans);
    }

    @Override
    public boolean insertTransB(TransB transB) {
        return 1 == transBMapper.insert(transB);
    }
}
