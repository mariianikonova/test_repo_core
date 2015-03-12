package collections;

import utils.CollectionStuffer;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * Created by user on 03.03.15.
 */
public class PriorityQueueImpl {

    public static void main(String[] args) {
        Queue<Integer> integerQueue = new LinkedList<>();

        CollectionStuffer.fillCollectionReverse(integerQueue, 5);
        integerQueue.forEach(System.out::println);

        System.out.println(" ==================== ");

        Queue<Integer> integerQueuePriority = new PriorityQueue<>(Integer::compareTo);
        CollectionStuffer.fillCollectionReverse(integerQueuePriority, 5);
        integerQueuePriority.forEach(System.out::println);
    }
}
