package com.mmall.concurrency.example.threadSafty.atomic;

import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS
 */
@Slf4j
@ThreadSafe
public class AtomicExample1 {

    //请求总数
    public static int clientTotal = 5000;

    //同时并发吃行的线程数
    public static int threadTotal = 200;

    //
    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.info("error: " + e.toString());
                }
                countDownLatch.countDown();

            });
        }
        countDownLatch.await();
        log.info("count:{}", count.get());
        executorService.shutdown();
    }

    /**
     * traditional CAS implementation, by determine whether if the value within an object is equal to the base
     * implementation's value of that object (in this case is the shared memory), so that it knows when to perform the
     * operation. If two values are equal, then it means the value is not been modified by another thread, perform add
     *  * operation. If two values are not equal, then it has been modified by another thread, do nothing but wait
     *  until another iteration performed.
     *
     *  When failed to perform the add operation, the program will keep iterating, this will drawn up
     *  some system resources.
     *
     */
    private static void add() {
        count.incrementAndGet();
        // count.getAndIncrement();
    }
}
