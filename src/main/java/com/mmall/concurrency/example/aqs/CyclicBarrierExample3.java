package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CyclicBarrierExample3 {

    //同步等待的线程数
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
        log.info("callback is running");
    });

    public static void main(String[] args) throws Exception{

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            int finalI = i;
            executorService.execute(() -> {
                try {
                    race(finalI);
                } catch (Exception e) {
                    log.error("exception", e);
                }
            });
        }
        executorService.shutdown();
    }

    public static void race(int i) throws Exception{
        Thread.sleep(1000);
        log.info("{} is ready", i);
        //每个线程被调用await方法之后, 计数器会+1, 当计数器达到创建cyclicbarrier时传入的5, 执行下面的操作.
        try {
            cyclicBarrier.await();
        } catch (Exception e) {
            log.warn("exception at await: {}", e);
        }
        log.info("{} continue", i);
    }
}
