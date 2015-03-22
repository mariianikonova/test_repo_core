package iteratorIterable;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by user on 01.03.15.
 */
//todo
public class IteratorCustom {

    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });


        set.add(2);
        set.add(1);
        set.add(1);
        System.out.println(set);


        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        System.out.println(set2);


        System.out.println(getNextElement(set2, 2));


       /* getPrevsElems(set2, 3);*/

    }

    public static <E> E getNextElement(Collection<E> collection, E currentElem) {

        java.util.Iterator<E> iter = collection.iterator();
        while (iter.hasNext()) {
            if (iter.next().equals(currentElem)) {
                if (iter.hasNext()) {
                    return iter.next();
                }
            }
        }
        return null;
    }


    public <E> Collection<E> getPrevsElems(Collection<E> collection, E elem) {

        ReverseIterator<E> iter = new ReverseIterator<>(/*collection*/);

        while (iter.hasNext()) {
            while (!iter.next().equals(elem)) {
                collection.remove(iter);
            }
        }
        System.out.println("getPrevsElems: " + collection.toString());
        return collection;
    }


    class ReverseIterator<E> implements java.util.Iterator<E> {

        class GenSet<E> {

            private E[] a;

            public GenSet(Class<E> c, int s) {
                // Use Array native method to create array of a type only known at run time
                @SuppressWarnings("unchecked")
                final E[] a = (E[]) Array.newInstance(c, s);
                this.a = a;
            }

            E get(int i) {
                return a[i];
            }
        }


        private E[] collection;
        private int current;
        private int size;

        public ReverseIterator() {
        }


        //TODO
      /*  ReverseIterator(Collection<E> collection) {
            Collections.unmodifiableCollection(collection);
            this.collection = collection.toArray(Array.newInstance(?, collection.size());
            this.current = collection.size() + 1;
            this.size = collection.size();
        }*/

        @Override
        public boolean hasNext() {
            if (current > 0) {
                return true;
            } else return false;
        }

        @Override
        public E next() {
            if (current > 0) {
                current--;
                return collection[current];
            }
            return null;
        }

        public E[] toArray(E[] a) {
            if (a.length < size)
                // Make a new array of a's runtime type, but my contents:
                return (E[]) Arrays.copyOf(a, size, a.getClass());
            System.arraycopy(a, 0, a, 0, size);
            if (a.length > size)
                a[size] = null;
            return a;
        }
    }
}

