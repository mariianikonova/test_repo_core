package concurrent.basicImplLock;


import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by user on 05.03.15.
 */
public class Operations {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final Account a = new Account(1000);
        final Account b = new Account(2000);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate((() -> System.out.println(Statistic.getFailCounter())), 1, 3000, TimeUnit.MILLISECONDS);

        for (int i = 0; i < 10; i++) {
            Future<Boolean> feature = executorService.submit(new concurrent.basicImplLock.Transfer(b, a, new Random().nextInt(400), i));
            System.out.println(feature.get().toString());
        }

        executorService.shutdown();
        executorService.awaitTermination(5000, TimeUnit.MILLISECONDS); // main thread wait
    }
}
