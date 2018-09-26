package springIOC.一接口多实现;

import org.springframework.stereotype.Service;

@Service
public class DogServiceImpl implements  IService {
    public void service(String name) {
        System.out.println("DogServiceImpl="+name);
    }
}
