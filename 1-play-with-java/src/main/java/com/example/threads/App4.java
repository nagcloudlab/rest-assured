package com.example.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App4 {

    public static CompletableFuture<String> getCoffee(){
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Coffee";
        });
    }

    public static void doTraining(){
        System.out.println("Nag doing training");
        System.out.println("requesting coffee");
        CompletableFuture<String> coffeeCompFuture = getCoffee();
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        coffeeCompFuture
                .thenAcceptAsync(coffee-> {
                    System.out.println("Nag got coffee: " + coffee);
                    System.out.println("Nag drinking coffee");
                }, executorService);
        System.out.println("Nag doing other work");
    }


    public static void main(String[] args) throws InterruptedException {


        doTraining();
        Thread.sleep(100000);



    }
}
