package com.mmall.concurrency.example.aqs;

public class SCWC {

    private class CountDownLatch {

        /**
         * Decrements the count of the latch, releasing all waiting threads if
         * the count reaches zero.
         *
         * <p>If the current count is greater than zero then it is decremented.
         * If the new count is zero then all waiting threads are re-enabled for
         * thread scheduling purposes.
         *
         * <p>If the current count equals zero then nothing happens.
         */
//    public void countDown() {
//        sync.releaseShared(1);
//    }

        /**
         * Causes the current thread to wait until the latch has counted down to
         * zero, unless the thread is {@linkplain Thread#interrupt interrupted}.
         *
         * <p>If the current count is zero then this method returns immediately.
         *
         * <p>If the current count is greater than zero then the current
         * thread becomes disabled for thread scheduling purposes and lies
         * dormant until one of two things happen:
         * <ul>
         * <li>The count reaches zero due to invocations of the
         * {@link #countDown} method; or
         * <li>Some other thread {@linkplain Thread#interrupt interrupts}
         * the current thread.
         * </ul>
         *
         * <p>If the current thread:
         * <ul>
         * <li>has its interrupted status set on entry to this method; or
         * <li>is {@linkplain Thread#interrupt interrupted} while waiting,
         * </ul>
         * then {@link InterruptedException} is thrown and the current thread's
         * interrupted status is cleared.
         *
         * @throws InterruptedException if the current thread is interrupted
         *         while waiting
         */
//    public void await() throws InterruptedException {
//        sync.acquireSharedInterruptibly(1);
//    }

        /**
         * Acquires in shared mode, aborting if interrupted.  Implemented
         * by first checking interrupt status, then invoking at least once
         * {@link #tryAcquireShared}, returning on success.  Otherwise the
         * thread is queued, possibly repeatedly blocking and unblocking,
         * invoking {@link #tryAcquireShared} until success or the thread
         * is interrupted.
         * @param arg the acquire argument.
         * This value is conveyed to {@link #tryAcquireShared} but is
         * otherwise uninterpreted and can represent anything
         * you like.
         * @throws InterruptedException if the current thread is interrupted
         */
//    public final void acquireSharedInterruptibly(int arg)
//            throws InterruptedException {
//        if (Thread.interrupted())
//            throw new InterruptedException();
//        if (tryAcquireShared(arg) < 0)
//            doAcquireSharedInterruptibly(arg);
//    }
    }

    private class Semaphore {

        /**
         * Acquires a permit from this semaphore, blocking until one is
         * available, or the thread is {@linkplain Thread#interrupt interrupted}.
         *
         * <p>Acquires a permit, if one is available and returns immediately,
         * reducing the number of available permits by one.
         *
         * <p>If no permit is available then the current thread becomes
         * disabled for thread scheduling purposes and lies dormant until
         * one of two things happens:
         * <ul>
         * <li>Some other thread invokes the {@link #release} method for this
         * semaphore and the current thread is next to be assigned a permit; or
         * <li>Some other thread {@linkplain Thread#interrupt interrupts}
         * the current thread.
         * </ul>
         *
         * <p>If the current thread:
         * <ul>
         * <li>has its interrupted status set on entry to this method; or
         * <li>is {@linkplain Thread#interrupt interrupted} while waiting
         * for a permit,
         * </ul>
         * then {@link InterruptedException} is thrown and the current thread's
         * interrupted status is cleared.
         *
         * @throws InterruptedException if the current thread is interrupted
        //         */
//        public void acquire() throws InterruptedException {
//            sync.acquireSharedInterruptibly(1);
//        }

        /**
         * Releases a permit, returning it to the semaphore.
         *
         * <p>Releases a permit, increasing the number of available permits by
         * one.  If any threads are trying to acquire a permit, then one is
         * selected and given the permit that was just released.  That thread
         * is (re)enabled for thread scheduling purposes.
         *
         * <p>There is no requirement that a thread that releases a permit must
         * have acquired that permit by calling {@link #acquire}.
         * Correct usage of a semaphore is established by programming convention
         * in the application.
         */
//        public void release() {
//            sync.releaseShared(1);
//        }
    }

    private class AQS {
        /**
         * Acquires in shared interruptible mode.
         * @param arg the acquire argument
         */
//    private void doAcquireSharedInterruptibly(int arg)
//            throws InterruptedException {
//        final Node node = addWaiter(Node.SHARED);
//        boolean failed = true;
//        try {
//            for (;;) {
//                final Node p = node.predecessor();
//                if (p == head) {
//                    int r = tryAcquireShared(arg);
//                    if (r >= 0) {
//                        setHeadAndPropagate(node, r);
//                        p.next = null; // help GC
//                        failed = false;
//                        return;
//                    }
//                }
//                if (shouldParkAfterFailedAcquire(p, node) &&
//                        parkAndCheckInterrupt())
//                    throw new InterruptedException();
//            }
//        } finally {
//            if (failed)
//                cancelAcquire(node);
//        }
//    }

        /**
         * Synchronization control For CountDownLatch.
         * Uses AQS state to represent count.
         */
//    private static final class Sync extends AbstractQueuedSynchronizer {
//        private static final long serialVersionUID = 4982264981922014374L;
//
//        Sync(int count) {
//            setState(count);
//        }
//
//        int getCount() {
//            return getState();
//        }
//
//        protected int tryAcquireShared(int acquires) {
//            return (getState() == 0) ? 1 : -1;
//        }
//
//        protected boolean tryReleaseShared(int releases) {
//            // Decrement count; signal when transition to zero
//            for (;;) {
//                int c = getState();
//                if (c == 0) //如果没有线程需要执行
//                    return false; //
//                int nextc = c-1;
//                if (compareAndSetState(c, nextc))
//                    return nextc == 0;
//            }
//        }
//    }


        /**
         * Releases in shared mode.  Implemented by unblocking one or more
         * threads if {@link #tryReleaseShared} returns true.
         *
         * @param arg the release argument.  This value is conveyed to
         *        {@link #tryReleaseShared} but is otherwise uninterpreted
         *        and can represent anything you like.
         * @return the value returned from {@link #tryReleaseShared}
         */
//    public final boolean releaseShared(int arg) {
//        if (tryReleaseShared(arg)) { //如果所有线程都已经执行完毕, 那么跳过
//            doReleaseShared();
//            return true;
//        }
//        return false;
//    }

        /**
         * Release action for shared mode -- signals successor and ensures
         * propagation. (Note: For exclusive mode, release just amounts
         * to calling unparkSuccessor of head if it needs signal.)
         */
//    private void doReleaseShared() {
//        /*
//         * Ensure that a release propagates, even if there are other
//         * in-progress acquires/releases.  This proceeds in the usual
//         * way of trying to unparkSuccessor of head if it needs
//         * signal. But if it does not, status is set to PROPAGATE to
//         * ensure that upon release, propagation continues.
//         * Additionally, we must loop in case a new node is added
//         * while we are doing this. Also, unlike other uses of
//         * unparkSuccessor, we need to know if CAS to reset status
//         * fails, if so rechecking.
//         */
//        for (;;) {
//            Node h = head;
//            if (h != null && h != tail) {
//                int ws = h.waitStatus;
//                if (ws == Node.SIGNAL) {
//                    if (!compareAndSetWaitStatus(h, Node.SIGNAL, 0))
//                        continue;            // loop to recheck cases
//                    unparkSuccessor(h);
//                }
//                else if (ws == 0 &&
//                        !compareAndSetWaitStatus(h, 0, Node.PROPAGATE))
//                    continue;                // loop on failed CAS
//            }
//            if (h == head)                   // loop if head changed
//                break;
//        }
//    }
    }

}
