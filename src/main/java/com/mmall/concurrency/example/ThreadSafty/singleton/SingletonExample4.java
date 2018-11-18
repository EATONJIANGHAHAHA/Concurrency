package com.mmall.concurrency.example.ThreadSafty.singleton;

import com.mmall.concurrency.annotations.NotRecommend;
import com.mmall.concurrency.annotations.NotThreadSafe;
import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 双层同步锁懒汉模式
 * 单例的实例在第一次使用时进行创建
 */
@NotThreadSafe
@Slf4j
public class SingletonExample4 {

    //单利对象
    private static SingletonExample4 INSTANCE = null;

    private SingletonExample4() {

    }

    //1. memory = allocate() 分配对象内存空间
    //2. ctroInstance() 初始化对象
    //3. instance = memory 设置instance指向刚分配的内存

    //由于JVM和CPU优化,发生了指令重排序:

    //1. memory = allocate() 分配对象内存空间
    //3. instance = memory 设置instance指向刚分配的内存
    //2. ctroInstance() 初始化对象

    //假设有线程A和线程B,并按照以上列第二种情况执行:

    //静态工厂方法
    public static SingletonExample4 getInstance() {
        if (INSTANCE == null) { //双重监测机制                    //B判断后发现 INSTANCE 已经有值,于是直接返回,可是返回的INSTANCE并没有被初始化.
            synchronized (SingletonExample4.class) { //同步锁
                if (INSTANCE == null) {
                    INSTANCE = new SingletonExample4();         //A - 3
                }
            }
        }
        return INSTANCE;
    }
}
