package com.perks.stuart.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PlayingWithFutures {

    private ExecutorService executorService = Executors.newCachedThreadPool();
    private Random random = new Random();

    public Integer classicFuture() {

        Future mySlowCountFuture = executorService.submit(
                () -> {
                    int count = 0;
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(1000);
                        count += 10;
                    }
                    System.out.println(Thread.currentThread().getName() + " is returning count " + count);
                    return count;
                });

        System.out.println(Thread.currentThread().getName() + " is working away on main thread");
        Integer count = null;
        try {
            count = (Integer) mySlowCountFuture.get();
            System.out.println(Thread.currentThread().getName() + " is returning count " + count);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return count;
    }


    public double getPrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
