package springIOC.一接口多实现;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class MainClass {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("springIOC.一接口多实现");
        Test t = context.getBean(Test.class);
        t.outList();
        Map<String,IService> map=new HashMap<String, IService>();
        map.put("aaaa",context.getBean("catServiceImpl",CatServiceImpl.class));
        map.put("bbb",context.getBean(DogServiceImpl.class));

        System.out.println(map.get("aaaa"));
        System.out.println(map.get("bbb"));
    }
}
