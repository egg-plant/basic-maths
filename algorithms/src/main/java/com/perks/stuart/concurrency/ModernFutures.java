package com.perks.stuart.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ModernFutures {

    private static final Logger logger = LoggerFactory.getLogger(ModernFutures.class);

    void playingWithCompletable() {

        // async says run in other thread
        CompletableFuture<String> startAsync = CompletableFuture
                .supplyAsync(
                        () -> {
                            logger.info("Supply Async 1");
                            return "Hello";
                        })
                .thenApplyAsync(
                        (input) -> {
                            logger.info("Then apply Async 1");
                            return input + " World";
                        })
                // flattens future result
                .thenComposeAsync(startFuture -> CompletableFuture.supplyAsync(
                        () -> {
                            logger.info("Supply Async join with previous in Async 1");
                            return startFuture + " Joining with OtherWorld CompletableFuture";
                        }));

        CompletableFuture<String> startSync = CompletableFuture
                .supplyAsync(
                        () -> {
                            logger.info("Supply Async 2");
                            return "Hello";
                        })
                .thenApply(
                        (input) -> {
                            logger.info("Then apply sync 2");
                            return input + " World";
                        })
                // flattens future result
                .thenCompose(startFuture -> CompletableFuture.supplyAsync(
                        () -> {
                            logger.info("Supply Async join with previous in sync 2");
                            return startFuture + " Joining with OtherWorld CompletableFuture";
                        }));


        try {
            logger.info("Waiting for result ... blocking {}", startAsync.get());
            logger.info("Waiting for result ... blocking {}", startSync.get());
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ModernFutures modernFutures = new ModernFutures();

        modernFutures.playingWithCompletable();


    }

}
