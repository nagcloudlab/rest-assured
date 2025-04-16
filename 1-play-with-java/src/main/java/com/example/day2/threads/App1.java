package com.example.day2.threads;

public class App1 {

    public static void test1() {
        System.out.println("test1 start");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("test1 end");
    }

    public static void test2() {
        System.out.println("test2 start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("test2 end");
    }


    public static void main(String[] args) {

        String threadName = Thread.currentThread().getName();

        Thread thread1 = new Thread(() -> {
            test1();
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            test2();
        }, "Thread-2");

        System.out.println("Main thread: " + threadName);
        System.out.println("Starting thread1");
        thread1.start(); // allocate stack space for thread1
        System.out.println("Starting thread2");
        thread2.start(); // allocate stack space for thread2

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All threads finished");




    }
}
