package concurrent;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created on 14.01.15.
 */
public class OperationsWithExecutors {

    private static AtomicInteger threadName = new AtomicInteger(0);

    final static Account acc1 = new Account(1000);
    final static Account acc2 = new Account(2000);
    static String lastFailedCounter;

    public static void main(String[] args) throws Transfer.InsufficientFundsException, InterruptedException {

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("LAST FAILED_COUNTER: " + Account.getFailCounter().toString());
                return lastFailedCounter = Account.getFailCounter().toString();
            }
        });

        Random rnd = new Random();
        transferWithExecutors(acc1,acc2,rnd.nextInt());
    }

    public static void transferWithExecutors(Account acc1, Account acc2, int rnd) throws Transfer.InsufficientFundsException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);


        for (int i = 0; i < 10; i++) {

            service.submit (new Runnable() {
                               @Override
                               public void run() {
                                   Thread.currentThread().setName("Thread " + threadName.incrementAndGet());
                                   System.out.println(Thread.currentThread().getName() + " Started at " + System.nanoTime());
                                   Transfer transferServ = new Transfer();
                                   transferServ.transfer(acc1, acc2, rnd);
                                   System.out.println(Thread.currentThread().getName() + " Finished at " + System.nanoTime());
                               }
                           }
            );
        }
        service.shutdown();
    }
}
