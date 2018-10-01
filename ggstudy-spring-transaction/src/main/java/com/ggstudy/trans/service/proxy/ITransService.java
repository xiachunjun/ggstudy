package com.ggstudy.trans.service.proxy;


import com.ggstudy.trans.domain.Trans;
import com.ggstudy.trans.domain.TransB;



/**
 * 测试内容及结论
 * 同一个类中,a和b均为操作数据库。
 * a有事务       b无事务
 * 场景1、a调b，a中出异常；结论：a、b都回滚
 * 场景2、a调b，b中出异常；结论：如果异常没被吃掉，最后抛出来被事务感知到，则回滚a和b。否则不回滚
 * 场景3、b调a，a中出异常；结论：不回滚
 * 场景4、b调a，b中出异常；结论：不回滚
 */

public interface ITransService {

    boolean insertTrans(Trans trans);

    boolean insertTransB(TransB transB);


}
