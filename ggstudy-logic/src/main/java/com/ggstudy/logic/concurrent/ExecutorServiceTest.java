package com.ggstudy.logic.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {
    public static volatile int a = 0;

    public static void main(String[] args) {
        ExecutorServiceTest est = new ExecutorServiceTest();
        // est.aaa();
        // est.singleThreadExecutorTest();//单线程
//        est.fixedThreadPoolTest();//固定大小
//		est.cachedThreadPoolTest();// 带缓存的
        // est.scheduledThreadPool();
        est.shutNowTest();

    }

    public void pools() {

    }

    /**
     * 单线程执行，没啥好说的额
     */
    public void singleThreadExecutorTest() {
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        for (int i = 1; i < 10; i++) {
            int tt = i;
            singleThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        System.out.println(Thread.currentThread() + "-" + tt);
                    }
                }
            });
        }
        singleThreadPool.shutdown();
    }

    /**
     * 全程解析：<br>
     * 1、创建了一个固定大小的线程池，大小为2（点进Executors.newFixedThreadPool(2)可以看到构造，其实就是创建固定大小的ThreadPoolExecutor）<br>
     * 2、有3个任务要执行（i），每个线程输出5次（j）<br>
     * 3、任务数大于线程池数量，意味着开始只能有两个任务被执行<br>
     * 4、特意设计在第二个任务的最后卡一下（taskId==1&&j==4），这样第一个线程已经执行完了，第二个还没执行完。<br>
     * 此时线程池中第一个线程是空闲的，就会去执行第三个任务，过了卡的几秒之后，第二个线程也结束了
     */
    public void fixedThreadPoolTest() {
        ExecutorService fixedtHreadPool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            int tt = i;
            fixedtHreadPool.execute(new Thread() {
                @Override
                public void run() {

                    for (int j = 0; j < 5; j++) {
                        try {
                            if (tt == 1 && j == 4) {// 这里是为了让第一波执行的两个线程中有一个在最后一点输出的时候卡一会儿，也就意味着：第一波的两个线程一个结束了，另一个要卡五秒
                                Thread.sleep(5000);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread() + "-" + tt);
                    }
                }
            });
        }
        fixedtHreadPool.shutdown();
    }

    /**
     * 1-创建了带缓存的线程池（点进Executors.newCachedThreadPool()里面可以看到，其实就是构造了一个ThreadPoolExecutor，初始线程数为0）
     * 2-创建100个任务，此时有任务要执行，线程池会创建出新的线程来执行，线程执行完任务后，会回到线程池；
     * 3-当有新任务时，发现有闲的线程就拿来执行任务。当没有闲的线程是，会创建新的 运行可以发现：最终是多个线程完成了这100个任务
     */
    public void cachedThreadPoolTest() {
        ExecutorService cachedThreadPool = new ThreadPoolExecutor(4, 8, 20L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(20));
        // ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 25; i++) {
            int tt = i;
            cachedThreadPool.execute(new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + "-" + tt);
                }
            });
        }
        cachedThreadPool.shutdown();
    }

    /**
     * 1-创建了一个有3个线程调度的的定时任务执行池 2-丢了是个任务让这个线程池执行，初始延迟2秒，执行，后每隔3秒执行一次
     * 注：这里没有shutdown，shutdown了就调度就没得执行了
     */
    public void scheduledThreadPool() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 10; i++) {
            int tt = i;
            scheduledThreadPool.scheduleWithFixedDelay(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread() + "-" + tt);
                }
            }, 2, 3, TimeUnit.SECONDS);
        }
        // scheduledThreadPool.shutdown();
    }

    public void aaa() {
        ExecutorService pool = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        CompletionService<String> completionService = new ExecutorCompletionService<String>(pool);
        completionService.submit(new AddCallable("1"));
        completionService.submit(new AddCallable("2"));
        completionService.submit(new AddCallable("3"));
        completionService.submit(new AddCallable("4"));
        completionService.submit(new AddCallable("5"));
        completionService.submit(new AddCallable("6"));
        completionService.submit(new AddCallable("7"));
        int nThread = 7;
        long timeLimit = System.currentTimeMillis() + 10000;
        while (nThread > 0) {
            if (System.currentTimeMillis() > timeLimit) {
                pool.shutdown();
                throw new RuntimeException("time_out");
            }
            Future<String> future = completionService.poll();
            if (future != null) {
                try {
                    String response = future.get();
                    System.out.println(response);
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException("time_out");
                } finally {
                    nThread--;
                }
            }
        }
        System.out.println(a);

    }

    class AddCallable implements Callable<String> {
        private String addCallableName;

        public AddCallable(String addCallableName) {
            this.addCallableName = addCallableName;
        }

        @Override
        public String call() throws Exception {
            System.out.println("addCallableName:" + addCallableName);
            for (int i = 0; i < 1000; i++) {
                // Thread.sleep(10);
                a++;
            }
            return addCallableName;
        }

    }


    public void shutNowTest() {
       final ExecutorService fixedtHreadPool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            int tt = i;
            fixedtHreadPool.execute(new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread() + "-" + tt+"-"+j);
                    }
                }
            });
        }


        Thread t=    new Thread(new Runnable() {
          @Override
          public void run() {
              fixedtHreadPool.shutdownNow();
          }
      });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ExecutorService        a= Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            a.execute(new Thread() {
                @Override
                public void run() {

                        System.out.println("111111111111111111");
                    }
            });
        }
    }

}
