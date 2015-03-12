package concurrent.basicMultiThreading;

/**
 * Created by user on 06.03.15.
 */
public class InterruptExample implements Runnable {


    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new InterruptExample(), "thread1");
        thread1.start();

        System.out.println(Thread.currentThread().getName() + " : Sleeping in main  thread for 5 s ... ");
        Thread.sleep(5000);

        System.out.println(Thread.currentThread().getName() + " : Interrupting thread");
        thread1.interrupt();
    }


    @Override
    public void run() {
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " : Interrupted by exception");
        }
    }
}
