package com.mmall.concurrency.example.ThreadSafty.singleton;

import com.mmall.concurrency.annotations.NotRecommend;
import com.mmall.concurrency.annotations.NotThreadSafe;
import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉模式
 * 单例的实例在第一次使用时进行创建
 */
@ThreadSafe
@NotRecommend
@Slf4j
public class SingletonExample3 {

    //单利对象
    private static SingletonExample3 INSTANCE = null;

    private SingletonExample3() {

    }

    //静态工厂方法
    public static synchronized SingletonExample3 getInstance() {
        if (INSTANCE == null)
            INSTANCE = new SingletonExample3();
        return INSTANCE;
    }
}
