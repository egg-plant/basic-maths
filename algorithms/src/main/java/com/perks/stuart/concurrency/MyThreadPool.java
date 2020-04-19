package com.perks.stuart.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {

    // Holds the tasks to execute
    private BlockingQueue<Runnable> workerQueue = new ArrayBlockingQueue(10);
    private final PoolWorker[] pool;
    private volatile boolean isThreadPoolRunning;

    public MyThreadPool(int numberOfThreads) {
        this.pool = new PoolWorker[numberOfThreads];

        this.isThreadPoolRunning = true;

        for (int i = 0; i < numberOfThreads; i++) {
            pool[i] = new PoolWorker();
            pool[i].start();
        }
    }

    public void execute(Runnable task) {
        workerQueue.add(task);
        // if not using a blocking queue can notify here as they are waiting to wake up runnables
    }


    private class PoolWorker extends Thread {

        @Override
        public void run() {
            Runnable task;
            // Shutdown all threads
            while (isThreadPoolRunning) {
                try {

                    // If this is not possible to use then notify wait
                    task = workerQueue.poll(100, TimeUnit.MILLISECONDS);

                    if (task instanceof Task) {
                        task.run();
                    } else if (task instanceof Finish) {
                        // or you interrupt is alternate
                        task.run();
                        isThreadPoolRunning = false;
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }

        }
    }

    public static class Task implements Runnable {

        private int num;

        public Task(int n) {
            num = n;
        }

        public void run() {
            System.out.println("Task " + num + " is running.");
        }
    }

    public static class Finish implements Runnable {

        public void run() {
            System.out.println("Task is shutting down.");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool(7);

        for (int i = 0; i < 5; i++) {
            Task task = new Task(i);
            pool.execute(task);
        }

        Thread.sleep(1000);
        pool.execute(new Finish());

    }
}


