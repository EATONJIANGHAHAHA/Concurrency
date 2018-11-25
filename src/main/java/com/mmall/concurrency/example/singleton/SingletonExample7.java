package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.Recommend;
import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 枚举模式,最安全,资源利用最大化,因为只有在第一次调用SingletonExample7.getInstance()方法的时候,枚举类才会进行初始化.
 */
@Slf4j
@ThreadSafe
@Recommend
public class SingletonExample7 {

    private SingletonExample7() {

    }

    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {

        INSTANCE;

        private SingletonExample7 singleton;

        //JVM保证这个方法绝对只能调用一次
        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singleton;
        }
    }

    public static void main(String[] args) {
        SingletonExample7.getInstance();
    }
}
