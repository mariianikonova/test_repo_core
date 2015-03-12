package concurrent.basicMultiThreading;

import java.io.IOException;
import java.util.Objects;

/**
 * Created by user on 08.03.15.
 */

//todo
public class WaitExample {

    /*monitor consept: wait; notify; synchronized*/
    /*just for synchronization object*/
    public static synchronized void main(String[] args) throws InterruptedException, IOException {
        final Object lock = new Object();
        final long[] array = new long[1];
        for (int k = 1; k < 10; k++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("run ");
                    synchronized (array) {
                        System.out.println("in");
                        array[0]++;
               /* long counter = 5000_000_000L;
                while (counter-- > 0) ;*/
                    }
                    System.out.println("  out");
                }
            }).start();
        }
        System.out.println(array[0]);

/*        Thread.sleep(1000);
        System.out.println(0);
        synchronized (lock) {
            System.out.println(1);
        }
        System.out.println(2);*/
    }
}
