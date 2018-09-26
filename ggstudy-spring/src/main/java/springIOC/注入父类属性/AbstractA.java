package springIOC.注入父类属性;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.reflect.ParameterizedType;

//@Slf4j
public  abstract class AbstractA<T,V> {

    @Autowired
    @Qualifier("serviceImpl1")
    AbstractService service;

    @Autowired
    B b;

    @Autowired
    V v;
//
    public void say(T t) {
        System.out.println(this.toStr(t) + service.toString());
        System.out.println(this.getVClass());
        System.out.println(v);
    }

    private Class<V> getVClass()
    {
        Class<V> tClass = (Class<V>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        return tClass;
    }


    abstract String toStr(T t);
}
