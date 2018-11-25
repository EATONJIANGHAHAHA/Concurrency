package com.mmall.concurrency.example.syncContainer;

import com.mmall.concurrency.annotations.NotThreadSafe;

import java.util.Iterator;
import java.util.Vector;

@NotThreadSafe
/**
 * 在使用迭代器或foreach循环的时候需要进行增删操作，不可以直接操作，做标记，在迭代完成之后在进行相关操作
 * 　
 */
public class VectorExample3 {

    //ConcurrentModificationException
    private static void test1(Vector<Integer> v1) { //foreach
        for (Integer i : v1) {
            if (i.equals(3)) {
                v1.remove(i);
            }
        }
    }

    //ConcurrentModificationException
    private static void test2(Vector<Integer> v1) { //iterator
        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i.equals(3)) {
                v1.remove(i);
            }
        }

    }

    //success
    private static void test3(Vector<Integer> v1) {
        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i).equals(3)) {
                v1.remove(i);
            }
        }

    }

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        test3(vector);
    }
}
