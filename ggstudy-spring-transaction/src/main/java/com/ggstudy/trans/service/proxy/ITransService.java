package com.ggstudy.trans.service.proxy;


import com.ggstudy.trans.domain.Trans;
import com.ggstudy.trans.domain.TransB;

public interface ITransService {

    boolean insertTrans(Trans trans);

    boolean insertTransB(TransB transB);

}
