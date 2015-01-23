package concurrent_test;

import java.util.concurrent.Semaphore;

/**
 * Created by lexor on 11.01.2015.
 */
public class Operations {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(1);
/*        new Worker(semaphore, "Adder", true).start();
        new Worker(semaphore, "Reducer", false).start();*/

/*        Lock lock = new ReentrantLock();
        lock.lock();*/

  /*      int count = 0;

        public int inc(){
            lock.lock();
            int newCount = ++count;
            lock.unlock();
            return newCount;
        }*/
/*

        try {
            //todo

        }finally {
            lock.unlock();
        }
*/




        final Account a = new Account(1000);
        final Account b = new Account(2000);
        Transfer transfer= new Transfer();

        Thread.currentThread().setName("Thread Main");
        System.out.println("Thread STARTED name: " + Thread.currentThread().getName());

        new Thread(new Runnable() {
            public void run() {
                System.out.println("Thread STARTED name: " + Thread.currentThread().getName());
                         Thread.currentThread().setName("Thread Second");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                transfer.transfer(a, b, 500);
            }
        }).start();
        System.out.println("Thread SLEEP name: " + Thread.currentThread().getName());
        Thread.sleep(2000);
        transfer.transfer(a, b, 300);
    }
}