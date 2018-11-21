package com.mmall.concurrency.example.ThreadSafty.publish;

import com.mmall.concurrency.annotations.NotRecommend;
import com.mmall.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanbeEscaped = 0;

    public Escape() {

        //这个操作会启动一个新线程
        new InnerClass();
    }

    private class InnerClass {

        //在对象没有被正确初始化之前,这个对象就已经被发布,
        public InnerClass() {
            log.info("{}", Escape.this.thisCanbeEscaped);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
