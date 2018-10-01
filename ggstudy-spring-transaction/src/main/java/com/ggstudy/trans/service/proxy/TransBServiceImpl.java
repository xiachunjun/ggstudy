package com.ggstudy.trans.service.proxy;

import com.ggstudy.trans.domain.TransB;
import com.ggstudy.trans.mapper.TransBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransBServiceImpl implements ITransBService {

    private TransBMapper transBMapper;

    @Autowired
    public TransBServiceImpl(TransBMapper transBMapper) {
        this.transBMapper = transBMapper;
    }

    @Transactional
    @Override
    public boolean insertTransB(TransB transB) {
        int i= transBMapper.insert(transB);

        return i==1;
    }
}
