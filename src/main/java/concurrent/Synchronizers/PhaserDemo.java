package concurrent.synchronizers;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 12.03.15.
 */
public class PhaserDemo {

    public static void main(String[] args) {
        Phaser phsr = new Phaser(1);  /*current thread registration*/
        int curPhase;

        System.out.println("Starting");

        new PhaserDemoThread(phsr, "A");
        new PhaserDemoThread(phsr, "B");
        new PhaserDemoThread(phsr, "C");

        //all thread wait for phase ONE completion
        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " complete");

        //all thread wait for phase TWO completion
        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " complete");

        //all thread wait for phase THREE completion
        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " complete");

        phsr.arriveAndDeregister();

        if (phsr.isTerminated()) {
            System.out.println("Phaser is terminated");
        }
    }

    private static class PhaserDemoThread implements Runnable {

        private Phaser phaser;
        String name;

        public PhaserDemoThread(Phaser phaser, String name) {
            this.phaser = phaser;
            this.name = name;
            phaser.register();
            new Thread(this).start();
        }

        @Override
        public void run() {
            System.out.println("Thread " + name + " ->Beggining phase ONE");
            phaser.arriveAndAwaitAdvance();//phase done
            //pause for sequentual out; Doesn`t have any matter for actual result;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread " + name + " ->Beggining phase TWO");
            phaser.arriveAndAwaitAdvance();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread " + name + " ->Beggining phase THREE");
            phaser.arriveAndDeregister();
        }
    }
}
