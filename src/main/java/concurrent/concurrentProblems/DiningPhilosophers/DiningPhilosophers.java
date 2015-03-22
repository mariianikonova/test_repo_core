package concurrent.concurrentProblems.diningPhilosophers;

/**
 * Created by user on 05.03.15.
 */
//todo
public class DiningPhilosophers {

    public static void main(String[] args) {

        Runnable p1 = new Philosopher();
        Runnable p2 = new Philosopher();
        Runnable p3 = new Philosopher();
        Runnable p4 = new Philosopher();
        Runnable p5 = new Philosopher();

        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(p3).start();
        new Thread(p4).start();
        new Thread(p5).start();
    }
}
