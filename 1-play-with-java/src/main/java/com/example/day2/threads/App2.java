package com.example.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App2 {

    public static void test1() {
        String threadName = Thread.currentThread().getName();
        System.out.println("test1 started by " + threadName);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("test1 end");
    }

    public static void test2() {
        String threadName = Thread.currentThread().getName();
        System.out.println("test2 started by " + threadName);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("test2 end");
    }


    public static void main(String[] args) {

        //ExecutorService executorService= Executors.newSingleThreadExecutor();
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        //ExecutorService executorService= Executors.newCachedThreadPool();
        //ExecutorService executorService= Executors.newScheduledThreadPool(2);
        executorService.submit(()->{
            test1();
        });
        executorService.submit(()->{
            test2();
        });

        executorService.shutdown();


    }
}
