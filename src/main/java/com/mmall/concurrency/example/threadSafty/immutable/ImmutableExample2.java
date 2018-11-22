package com.mmall.concurrency.example.threadSafty.immutable;

import com.google.common.collect.Maps;
import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

@Slf4j
@ThreadSafe
public class ImmutableExample2 {

    //使用final修饰的变量,只是不允许指向另一个对象,但是对象里面的成员变量时依然允许被修改的.这里容易产生线程不安全问题.
    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 2);
        map.put(5, 6);
        //这个方法返回一个final的map，因此它的内部也是不可变的，保证了线程安全．
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1, 3);
        log.info("{}", map.get(1));
    }
}
