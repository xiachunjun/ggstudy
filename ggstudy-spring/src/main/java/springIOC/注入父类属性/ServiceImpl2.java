package springIOC.注入父类属性;

import org.springframework.stereotype.Service;

@Service("serviceImpl2")
public class ServiceImpl2 extends AbstractService{
    public void service(String who) {
        System.out.println("ServiceImpl2-服务："+who);
    }
}
