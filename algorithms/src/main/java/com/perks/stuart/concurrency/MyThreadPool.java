package com.perks.stuart.concurrency;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MyThreadPool {

    // Holds the tasks to execute
    private Queue<Runnable> workerQueue = new ConcurrentLinkedQueue<>();
    private final int numberOfThreads;
    private final PoolWorker[] pool;

    public MyThreadPool(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
        this.pool = new PoolWorker[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            pool[i] = new PoolWorker();
            pool[i].start();
        }
    }

    public void execute(Runnable task) {
        synchronized (workerQueue) {
            workerQueue.add(task);
            workerQueue.notify();
        }
    }


    private class PoolWorker extends Thread {

        @Override
        public void run() {
            Runnable task = null;

            // think about shutting down.
            while (true) {
                synchronized (workerQueue) {
                    while (workerQueue.isEmpty()) {
                        try {
                            workerQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task = workerQueue.poll();
                }
                task.run();
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


    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool(7);

        for (int i = 0; i < 5; i++) {
            Task task = new Task(i);
            pool.execute(task);
        }
    }
}


