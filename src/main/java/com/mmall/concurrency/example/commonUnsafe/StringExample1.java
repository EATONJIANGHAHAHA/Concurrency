package com.mmall.concurrency.example.commonUnsafe;

import com.mmall.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@NotThreadSafe
public class StringExample1 {

    //请求总数
    public static int clientTotal = 5000;

    //同时并发吃行的线程数
    public static int threadTotal = 200;

    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    //判断进程是否允许被执行
                    semaphore.acquire();
                    update();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                //闭锁统计
                countDownLatch.countDown();

            });
        }
        countDownLatch.await();
        log.info("size:{}", stringBuilder.length());
        executorService.shutdown();
    }

    /**
     * 通常情况下,如果线程封闭,应该使用StringBuilder,它的性能会有所提升.
     */
    private static void update() {
        stringBuilder.append("1");
    }
}
