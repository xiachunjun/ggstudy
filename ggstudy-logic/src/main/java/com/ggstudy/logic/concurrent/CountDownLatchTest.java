package com.ggstudy.logic.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(100);
        Long st=System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(new Random().nextInt(1000));
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            });
        }
        try {
            System.out.println("等待执行完成。。。。。。。");
            latch.await(10,TimeUnit.SECONDS);
            System.out.println("count:"+latch.getCount());
            Long ed=System.currentTimeMillis();
            System.out.println(ed-st);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }

    }

}
