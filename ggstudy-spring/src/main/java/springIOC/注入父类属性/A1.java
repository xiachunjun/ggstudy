package springIOC.注入父类属性;

import org.springframework.stereotype.Component;

@Component
public class A1 extends AbstractA<B,ServiceImpl2> {

    @Override
    String toStr(B b) {
        return b.toString();
    }

}
