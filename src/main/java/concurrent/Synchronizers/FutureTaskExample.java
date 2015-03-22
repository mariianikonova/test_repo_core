package concurrent.synchronizers;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by user on 09.03.15.
 */
public class FutureTaskExample {
    private static FutureTask<String> futureTask = new FutureTask<>(() -> {
        Thread.sleep(3000);
        return new String("testFeature");
    }
    );

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("beforeRun");
        new Thread(futureTask).start();
        System.out.println("beforeFeature");
        System.out.println(futureTask.get());
        System.out.println("afterFeature");
    }
}
