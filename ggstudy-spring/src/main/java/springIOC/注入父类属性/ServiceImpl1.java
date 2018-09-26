package springIOC.注入父类属性;

import org.springframework.stereotype.Service;

@Service("serviceImpl1")
public class ServiceImpl1 extends AbstractService{
    public void service(String who) {
        System.out.println("ServiceImpl1-服务："+who);
    }
}
