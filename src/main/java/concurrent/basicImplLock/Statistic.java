package concurrent.basicImplLock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by user on 09.03.15.
 */
public class Statistic {

    private static AtomicInteger failCounter = new AtomicInteger(0);

    public static AtomicInteger getFailCounter() {
        return failCounter;
    }

    public static void incFailedCounter() {
        failCounter.incrementAndGet();
    }

}
