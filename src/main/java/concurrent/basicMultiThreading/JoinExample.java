package concurrent.basicMultiThreading;

/**
 * Created by user on 06.03.15.
 */
public class JoinExample implements Runnable {

    private String toPrint;
    private int forSleep;
    private Thread currentThread = Thread.currentThread();

    public JoinExample(String toPrint, int forSleep) {
        this.toPrint = toPrint;
        this.forSleep = forSleep;
    }

    public static void main(String[] args) {

        Thread thread1 = new Thread(new JoinExample("A", 250), "thread1");
        Thread thread2 = new Thread(new JoinExample("B", 100), "thread2");
        Thread thread3 = new Thread(new JoinExample("С", 300), "thread3");
        Thread thread4 = new Thread(new JoinExample("Daemon", 2000), "thread4");

        thread1.start();

        thread4.setDaemon(true);
        thread4.start();

        try {
            Thread.sleep(6000); //join current thread, - main
            thread2.start();
            thread2.getUncaughtExceptionHandler();
            thread3.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("Main joined");
        try {
            currentThread.join();
            for (int i = 0; i < 10; i++) {
                Thread.sleep(forSleep);
                System.out.println(toPrint);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
