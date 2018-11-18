package com.mmall.concurrency.example.ThreadSafty.singleton;

import com.mmall.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉模式
 * 单例的实例在第一次使用时进行创建
 */
@NotThreadSafe
@Slf4j
public class SingletonExample1 {

    //单利对象
    private static SingletonExample1 INSTANCE = null;

    private SingletonExample1() {

    }

    //静态工厂方法
    public static SingletonExample1 getInstance() {
        if (INSTANCE == null)
            INSTANCE = new SingletonExample1();
        return INSTANCE;
    }
}
