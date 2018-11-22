package com.mmall.concurrency.example.threadSafty.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 如果有其他类继集成本类,synchronized 方法在子类中将不会再具有synchronized效力.
 * 因为synchronized 不属于方法声明的一个部分.
 */
@Slf4j
public class SynchronizedExample1 {

    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 - {} - {}", j, i);
            }
        }
    }

    public synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {} - {}", j, i);
        }
    }

    /**
     * 静态同步方法无论是用哪个对象调用,结果都会是同步的
     * @param args
     */
    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
           example1.test2(1);
        });
        executorService.execute(() -> {
            example2.test2(2);
        });
    }
}
