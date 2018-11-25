package com.mmall.concurrency.example.syncContainer;

public class SCWC {

    /**
     * Returns a synchronized (thread-safe) list backed by the specified
     * list.  In order to guarantee serial access, it is critical that
     * <strong>all</strong> access to the backing list is accomplished
     * through the returned list.<p>
     *
     * It is imperative that the user manually synchronize on the returned
     * list when iterating over it:
     * <pre>
     *  List list = Collections.synchronizedList(new ArrayList());
     *      ...
     *  synchronized (list) {
     *      Iterator i = list.iterator(); // Must be in synchronized block
     *      while (i.hasNext())
     *          foo(i.next());
     *  }
     * </pre>
     * Failure to follow this advice may result in non-deterministic behavior.
     *
     * <p>The returned list will be serializable if the specified list is
     * serializable.
     *
     * @param  <T> the class of the objects in the list
     * @param  list the list to be "wrapped" in a synchronized list.
     * @return a synchronized view of the specified list.
     */
/*    public static <T> List<T> synchronizedList(List<T> list) {
        return (list instanceof RandomAccess ?
                new SynchronizedRandomAccessList<>(list) :
                new SynchronizedList<>(list));
    }*/

    /**
     * @serial include
     */
//    static class SynchronizedList<E>
//            extends SynchronizedCollection<E>
//            implements List<E> {
//        private static final long serialVersionUID = -7754090372962971524L;
//
//        final List<E> list;
//
//        SynchronizedList(List<E> list) {
//            super(list);
//            this.list = list;
//        }
//        SynchronizedList(List<E> list, Object mutex) {
//            super(list, mutex);
//            this.list = list;
//        }
//
//        public boolean equals(Object o) {
//            if (this == o)
//                return true;
//            synchronized (mutex) {return list.equals(o);}
//        }
//        public int hashCode() {
//            synchronized (mutex) {return list.hashCode();}
//        }
//
//        public E get(int index) {
//            synchronized (mutex) {return list.get(index);}
//        }
//        public E set(int index, E element) {
//            synchronized (mutex) {return list.set(index, element);}
//        }
//        public void add(int index, E element) {
//            synchronized (mutex) {list.add(index, element);}
//        }
//        public E remove(int index) {
//            synchronized (mutex) {return list.remove(index);}
//        }
//
//        public int indexOf(Object o) {
//            synchronized (mutex) {return list.indexOf(o);}
//        }
//        public int lastIndexOf(Object o) {
//            synchronized (mutex) {return list.lastIndexOf(o);}
//        }
//
//        public boolean addAll(int index, Collection<? extends E> c) {
//            synchronized (mutex) {return list.addAll(index, c);}
//        }
//
//        public ListIterator<E> listIterator() {
//            return list.listIterator(); // Must be manually synched by user
//        }
//
//        public ListIterator<E> listIterator(int index) {
//            return list.listIterator(index); // Must be manually synched by user
//        }
//
//        public List<E> subList(int fromIndex, int toIndex) {
//            synchronized (mutex) {
//                return new SynchronizedList<>(list.subList(fromIndex, toIndex),
//                        mutex);
//            }
//        }
//
//        @Override
//        public void replaceAll(UnaryOperator<E> operator) {
//            synchronized (mutex) {list.replaceAll(operator);}
//        }
//        @Override
//        public void sort(Comparator<? super E> c) {
//            synchronized (mutex) {list.sort(c);}
//        }
//
//        /**
//         * SynchronizedRandomAccessList instances are serialized as
//         * SynchronizedList instances to allow them to be deserialized
//         * in pre-1.4 JREs (which do not have SynchronizedRandomAccessList).
//         * This method inverts the transformation.  As a beneficial
//         * side-effect, it also grafts the RandomAccess marker onto
//         * SynchronizedList instances that were serialized in pre-1.4 JREs.
//         *
//         * Note: Unfortunately, SynchronizedRandomAccessList instances
//         * serialized in 1.4.1 and deserialized in 1.4 will become
//         * SynchronizedList instances, as this method was missing in 1.4.
//         */
//        private Object readResolve() {
//            return (list instanceof RandomAccess
//                    ? new SynchronizedRandomAccessList<>(list)
//                    : this);
//        }
}
