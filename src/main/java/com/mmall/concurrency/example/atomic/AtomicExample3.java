package com.mmall.concurrency.example.atomic;

import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

@Slf4j
@ThreadSafe
public class AtomicExample3 {
    //请求总数
    public static int clientTotal = 5000;

    //同时并发吃行的线程数
    public static int threadTotal = 200;


    public static LongAdder count = new LongAdder();

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
        log.info("count:{}", count);
        executorService.shutdown();
    }

    /**
     * LongAdder的设计思想：核心是将热点数据分离，将内部数据value分成一个数组，每个线程访问时，
     * 通过hash等算法映射到其中一个数字进行技术，而最终计数结果为这个数组的求和累加，
     * 其中热点数据value会被分离成多个热点单元的数据cell，每个cell独自维护内部的值，
     * 当前value的实际值由所有的cell累积合成，从而使热点进行了有效的分离，提高了并行度
     * LongAdder 在低并发的时候通过直接操作base，可以很好的保证和Atomic的性能基本一致，
     * 在高并发的场景，通过热点分区来提高并行度
     */
    private static void add() {
        count.increment();
    }
}
