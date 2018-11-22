package com.mmall.concurrency.example.threadSafty.threadLocal;

public class SCWC {

    /**
     * Sets the current thread's copy of this thread-local variable
     * to the specified value.  Most subclasses will have no need to
     * override this method, relying solely on the {@link #initialValue}
     * method to set the values of thread-locals.
     *
     * @param value the value to be stored in the current thread's copy of
     *        this thread-local.
     */
//    public void set(T value) {
//    //currentThread()方法返回本线程
//        Thread t = Thread.currentThread();
//
//        ThreadLocalMap map = getMap(t);
//        if (map != null)
//            map.set(this, value);
//        else
//            createMap(t, value);
//    }

    /**
     * Returns a reference to the currently executing thread object.
     *
     * @return  the currently executing thread.
     */
//    public static native Thread currentThread();

    /**
     * Get the map associated with a ThreadLocal. Overridden in
     * InheritableThreadLocal.
     *
     * @param  t the current thread
     * @return the map
     */
//    ThreadLocalMap getMap(Thread t) {
//        return t.threadLocals;
//    }

     /**
      * ThreadLocal values pertaining to this thread. This map is maintained
      * by the ThreadLocal class.
      */
//    ThreadLocal.ThreadLocalMap threadLocals = null;

    /**
     * ThreadLocalMap is a customized hash map suitable only for
     * maintaining thread local values. No operations are exported
     * outside of the ThreadLocal class. The class is package private to
     * allow declaration of fields in class Thread.  To help deal with
     * very large and long-lived usages, the hash table entries use
     * WeakReferences for keys. However, since reference queues are not
     * used, stale entries are guaranteed to be removed only when
     * the table starts running out of space.
     */
//    static class ThreadLocalMap {...}
}
