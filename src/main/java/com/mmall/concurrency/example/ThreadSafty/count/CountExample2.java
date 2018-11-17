package com.mmall.concurrency.example.ThreadSafty.count;

import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@ThreadSafe
public class CountExample2 {

    //请求总数
    public static int clientTotal = 5000;

    //同时并发吃行的线程数
    public static int threadTotal = 200;

    //
    public static int count = 0;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semp = new Semaphore(threadTotal);
        for (int index = 0; index < clientTotal; index++) {
            exec.execute(() -> {
                try {
                    semp.acquire();
                    add();
                    semp.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
            });
        }
        exec.shutdown();
        log.info("count:{}", count);
    }

    private synchronized static void add() {
        count++;
    }
}
