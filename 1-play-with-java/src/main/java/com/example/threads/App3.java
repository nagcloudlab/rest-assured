package com.example.threads;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.*;

public class App3 {
    public static void main(String[] args) {


        Callable<String[]> callable = () -> {
            FileReader fileReader = new FileReader(new File("/home/nag/rest-assured/1-play-with-java/report.csv"));
            String[] csvReport = new String[0];
            try (BufferedReader br = new BufferedReader(fileReader)) {
                csvReport = br.lines().toArray(String[]::new);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return csvReport;
        };

        // thread-pool
        ExecutorService executorService = Executors.newFixedThreadPool(10);


        // main thread , submitting the task to the thread-pool, expecting the result
        Future<String[]> future = executorService.submit(callable);
        //  main thread with other work..
        try {
            String[] csvReport = future.get(); // if result not ready, wait for it else continue
            for (String s : csvReport) {
                System.out.println(s);
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }


    }
}
