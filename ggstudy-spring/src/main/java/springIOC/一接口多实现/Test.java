package springIOC.一接口多实现;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class Test {

    @Autowired
    List<IService> list;

    @Autowired
    Map<String,IService> map;


    public void outList() {
        for (IService v:list
             ) {
            System.out.println(v);
        }
        for (String key:map.keySet()) {
            System.out.println(key+"="+map.get(key));
        }

    }
}
