package utils;

import java.util.Collection;

/**
 * Created by user on 03.03.15.
 */
public class CollectionStuffer {

    public static void fillCollection(Collection<Integer> collection, int amount) {

        for (int i = 0; i < amount; i++) {
            collection.add(i);
        }
    }

    public static void fillCollectionReverse(Collection<Integer> collection, int amount) {

        for (int i = amount; i > 0; i--) {
            collection.add(i);
        }
    }

}
