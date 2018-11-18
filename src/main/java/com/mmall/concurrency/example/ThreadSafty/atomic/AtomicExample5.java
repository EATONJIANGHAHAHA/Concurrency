package com.mmall.concurrency.example.ThreadSafty.atomic;

import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
@ThreadSafe
public class AtomicExample5 {

    /**
     * AtomicIntegerFieldUpdater 核心是原子性的去更新某一个类的实例的指定的某一个字段
     * 构造函数第一个参数为类定义，第二个参数为指定字段的属性名，必须是volatile修饰并且非static的字段
     */
    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    @Getter
    private volatile int count = 100;

    private static AtomicExample5 example5 = new AtomicExample5();

    public static void main(String[] args) {
        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update sucess, {}", example5.getCount());
        }
        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update sucess, {}", example5.getCount());
        } else {
            log.info("update failed, {}", example5.getCount());
        }

    }
}
