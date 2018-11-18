package com.mmall.concurrency.example.ThreadSafty.singleton;

import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 双层同步锁懒汉模式
 * 单例的实例在第一次使用时进行创建
 */
@ThreadSafe
@Slf4j
public class SingletonExample5 {

    //单利对象 不允许指令重排序
    private volatile static SingletonExample5 INSTANCE = null;

    private SingletonExample5() {

    }

    //1. memory = allocate() 分配对象内存空间
    //2. ctroInstance() 初始化对象
    //3. instance = memory 设置instance指向刚分配的内存

    //由于JVM和CPU优化,可能发生了指令重排序, 但是通过volatile可以限制指令重排序的发生.

    //假设有线程A和线程B,并按照以上列第二种情况执行:

    //静态工厂方法
    public static SingletonExample5 getInstance() {
        if (INSTANCE == null) { //双重监测机制                    //B
            synchronized (SingletonExample5.class) { //同步锁
                if (INSTANCE == null) {
                    INSTANCE = new SingletonExample5();         //A - 3
                }
            }
        }
        return INSTANCE;
    }
}
