package com.mmall.concurrency.example.threadSafty.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 使用immutable*创建的集合在执行增删改操作的时候会抛异常，因此简介保证了线程安全
 */
@Slf4j
@ThreadSafe
public class ImmutableExample3 {

    private final static ImmutableList list = ImmutableList.of(1,2,3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer, Integer> map = ImmutableMap.of(1, 2, 3, 4);

    private final static ImmutableMap<Integer, Integer> map2 = ImmutableMap.<Integer, Integer>builder()
            .put(1, 2).put(3, 4).build();

    public static void main(String[] args) {
        //废弃方法
//        list.add(4);
//        set.add(4);
//        map.put(1, 4);
//        map2.put(1, 4);
        System.out.println(map.get(3));
    }
}
