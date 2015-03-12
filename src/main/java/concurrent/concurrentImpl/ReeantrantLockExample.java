package concurrent.concurrentImpl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by user on 09.03.15.
 */
public class ReeantrantLockExample {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            //some action
        } finally {
            lock.unlock();
        }
    }
}

