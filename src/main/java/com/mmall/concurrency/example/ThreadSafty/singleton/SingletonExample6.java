package com.mmall.concurrency.example.ThreadSafty.singleton;

import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 饿汉模式
 *
 */
@ThreadSafe
@Slf4j
public class SingletonExample6 {

    //单利对象
    private static SingletonExample6 INSTANCE; //1

    private SingletonExample6() {

    }

    //使用静态代码块的时候要注意顺序,静态代码是按顺序执行的.
    static {
        INSTANCE = new SingletonExample6(); //2
    }

    //静态工厂方法
    public static SingletonExample6 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
}
