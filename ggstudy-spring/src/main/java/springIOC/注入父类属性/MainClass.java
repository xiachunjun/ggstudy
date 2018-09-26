package springIOC.注入父类属性;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("springIOC.注入父类属性");
        A1 a1=context.getBean(A1.class);
        a1.say(context.getBean(B.class));
    }
}
