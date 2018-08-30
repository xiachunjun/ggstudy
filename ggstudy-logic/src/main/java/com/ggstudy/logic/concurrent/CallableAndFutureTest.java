package com.ggstudy.logic.concurrent;

import com.alibaba.fastjson.parser.Feature;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallableAndFutureTest {
    static Long invokeAllTime = 0L;
    static Long completionServiceTime = 0L;

    public static void main(String[] args) {
        CallableAndFutureTest caf = new CallableAndFutureTest();
//        caf.completionServiceTest();
        caf.callableTestBak();
        caf.callableTest();
        System.out.println(invokeAllTime-completionServiceTime);
    }

    public void completionServiceTest() {
        ExecutorService pool = new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(10));

        CompletionService<String> completionService = new ExecutorCompletionService<String>(pool);
        for (int i = 0; i < 10; i++) {
            Callable<String> c = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(new Random().nextInt(1000));
                    String res = Thread.currentThread().getName() + "";
                    return res;
                }
            };
            completionService.submit(c);
        }
        int num = 0;

        while (num < 10) {
            Future<String> f = completionService.poll();// 不会阻塞等待
            // Future<String> f=completionService.take();//会阻塞等待
            if (f != null) {
                try {
                    String s = f.get();
                    System.out.println(num + "===" + s);
                    num++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }

        pool.shutdown();

    }


    public void callableTest() {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        List<Callable<String>> workList = new ArrayList<>();
        Long begin = System.nanoTime();
        for (int i = 0; i < 40; i++) {
            int j = i;
            workList.add(() -> {
                if (j % 2 == 0) {
                    Thread.sleep(1000);
                }
                return "a+" + j;
            });
        }

        try {
            List<Future<String>> future = pool.invokeAll(workList);
            List<String> strs = new ArrayList<>();
            for (Future<String> fut : future) {
                String str = fut.get();
//                System.out.println(str);
                strs.add(str);
            }
            invokeAllTime = System.nanoTime() - begin;
            System.out.println(strs);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            pool.shutdown();
        }
    }

    /**
     * callableTest的对照，测试效率
     */
    public void callableTestBak() {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        CompletionService<String> completionService = new ExecutorCompletionService<String>(pool);
        Long begin = System.nanoTime();
        for (int i = 0; i < 40; i++) {
            int j = i;
            completionService.submit(() -> {
                if (j % 2 == 0) {
                    Thread.sleep(1000);
                }
                return "a+" + j;
            });
        }

        int num = 0;
        List<String> strs = new ArrayList<>();
        while (num < 40) {
            Future<String> f = completionService.poll();// 不会阻塞等待
            if (f != null) {
                try {
                    String str = f.get();
//                    System.out.println(str);
                    strs.add(str);
                    num++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        pool.shutdown();
        completionServiceTime = System.nanoTime() - begin;
        System.out.println(strs);
    }


}
