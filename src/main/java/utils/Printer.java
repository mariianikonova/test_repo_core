package utils;

import java.util.Collection;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created by user on 03.03.15.
 */
public interface Printer {

    public static class PrinterC<T> {

        public static final <T> void printC(Collection<T> collection) {
            collection.forEach((T) -> System.out.println(T.toString()));
        }
    }

    public static class PrinterM<K, V> {

        public static final <K, V> void printM(Map<K, V> collection) {
            collection.forEach((K, V) -> System.out.println(K.toString() + " : " + V.toString()));
        }
    }

}
