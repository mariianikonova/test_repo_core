package collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by user on 03.03.15.
 */
public class SimpleLruCache extends LinkedHashMap {

    private final int capacity;

    public SimpleLruCache(int capacity) {
        super(capacity + 1, 1.1f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return this.size() > capacity;
    }

    /*lasts 2, cause: 1,3 - eldest and never used*/
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> simpleLruCache = new SimpleLruCache(2);
        simpleLruCache.put(1, 1);
        simpleLruCache.put(2, 2);
        simpleLruCache.put(3, 3);

        simpleLruCache.get(2);

        simpleLruCache.put(5, 5);

        print(simpleLruCache);
    }

    private static void print(LinkedHashMap<Integer, Integer> simpleLruCache) {
        simpleLruCache.forEach((Integer integer, Integer integer2) -> System.out.println(String.valueOf(integer) + " : " + String.valueOf(integer2)));
    }
}
