package com.mmall.concurrency.example.ThreadSafty.singleton;

import com.mmall.concurrency.annotations.NotThreadSafe;
import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 饿汉模式
 * 如果构造方法中存在较多的计算,则在建立的时候会引起相关的性能问题
 * 如果只进行了类的加载,却没有进行实际的调用,会造成对资源的浪费
 * 尽量避免私有构造函数没有过多的计算.
 */
@ThreadSafe
@Slf4j
public class SingletonExample2 {

    //单利对象
    private static SingletonExample2 INSTANCE = new SingletonExample2();

    private SingletonExample2() {

    }

    //静态工厂方法
    public static SingletonExample2 getInstance() {
        return INSTANCE;
    }
}
