package com.ggstudy.trans;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@ComponentScan(basePackages = "com.ggstudy.trans.config")
@SpringBootApplication
public class TransApplication {
    public static void main(String[] args) {
    SpringApplication app=new SpringApplication(TransApplication.class);
        app.setBanner(new Banner() {
            @Override
            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
                out.println("这里banner随便写");
            }
        });
        app.run();
    }


}
