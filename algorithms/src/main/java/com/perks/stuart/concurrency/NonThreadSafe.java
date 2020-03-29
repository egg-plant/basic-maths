package com.perks.stuart.concurrency;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NonThreadSafe {

    private static Logger logger = LoggerFactory.getLogger(NonThreadSafe.class);
    private int value = 0;
    private int unsafe = 0;

    public int getNext() {
        return value++;
    }

    private synchronized void setUnsafeInt(int set) {
        unsafe = set;
    }

    public void runner() {
        ExecutorService service = Executors.newFixedThreadPool(5);

        service.submit(() -> {
            logger.info("Get next is 1 {}", getNext());
            setUnsafeInt(4);
        });

        service.submit(() -> {
            logger.info("Get next is 2 {}", getNext());
            setUnsafeInt(2);
        });

        service.submit(() -> {
            logger.info("Get next is 3 {}", getNext());
            setUnsafeInt(12);
        });

        service.submit(() -> {
            logger.info("Get next is 4 {}", getNext());
            setUnsafeInt(114);
        });

        service.submit(() -> {
            logger.info("Get next is 5 {}", getNext());
            setUnsafeInt(55);
        });

        logger.info("value is " + value);
        logger.info("unsafe is " + unsafe);

        service.shutdown();

    }

    public static void main(String[] args) {
        NonThreadSafe nonThreadSafe = new NonThreadSafe();
        nonThreadSafe.runner();
    }

}
