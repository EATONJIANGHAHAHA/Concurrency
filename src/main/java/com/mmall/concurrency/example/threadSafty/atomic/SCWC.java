package com.mmall.concurrency.example.threadSafty.atomic;

public class SCWC {

    class Source {

        /**
         * Atomically increments by one the current value.
         *
         * @return the previous value
         */
//        public final int getAndIncrement() {
//            // 主要是调用了unsafe的方法
//            //     private static final Unsafe unsafe = Unsafe.getUnsafe();
//            return unsafe.getAndAddInt(this, valueOffset, 1);
//        }


        /**
         *  获取底层当前的值并且+1
         * @param var1 需要操作的AtomicInteger 对象
         * @param var2 当前的值
         * @param var4 要增加的值
         */
//        public final int getAndAddInt(Object var1, long var2, int var4) {
//            int var5;
//            do {
//                // 获取底层的该对象当前的值
//                var5 = this.getIntVolatile(var1, var2);
//                // 获取完底层的值和自增操作之间，可能系统的值已经又被其他线程改变了
//                //如果又被改变了，则重新计算系统底层的值，并重新执行本地方法
//            } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));
//
//            return var5;
//        }


        /**
         * 本地的CAS方法核心
         * @param var1 需要操作的AtomicInteger 对象
         * @param var2 当前本地变量中的的值
         * @param var4 当前系统从底层传来的值
         * @param var5 要更新后的值
         * @Return 如果当前本地变量的值（var2）与底层的值(var4)不等，则返回false，否则更新为var5的值并返回True
         */
//        public final native boolean compareAndSwapInt(Object var1, long var2, int var4, int var5);


        /**
         * Atomically sets the value to the given updated value
         * if the current value {@code ==} the expected value.
         *
         * @param expect the expected value
         * @param update the new value
         * @return {@code true} if successful. False return indicates that
         * the actual value was not equal to the expected value.
         */
//        public final boolean compareAndSet(boolean expect, boolean update) {
//            int e = expect ? 1 : 0;
//            int u = update ? 1 : 0;
//            return unsafe.compareAndSwapInt(this, valueOffset, e, u);
//        }


        /**
         * Atomically sets the value of both the reference and stamp
         * to the given update values if the
         * current reference is {@code ==} to the expected reference
         * and the current stamp is equal to the expected stamp.
         *
         * @param expectedReference the expected value of the reference
         * @param newReference the new value for the reference
         * @param expectedStamp the expected value of the stamp
         * @param newStamp the new value for the stamp
         * @return {@code true} if successful
         */
//        public boolean compareAndSet(V   expectedReference,
//                                     V   newReference,
//                                     int expectedStamp,
//                                     int newStamp) {
//            Pair<V> current = pair;
//            return
//                    expectedReference == current.reference &&
//                            expectedStamp == current.stamp &&
//                            ((newReference == current.reference &&
//                                    newStamp == current.stamp) ||
//                                    casPair(current, Pair.of(newReference, newStamp)));
//        }
    }


}
