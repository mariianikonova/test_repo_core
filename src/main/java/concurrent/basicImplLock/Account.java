package concurrent.basicImplLock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by user on 05.03.15.
 */

//need synchronization right to this class
public class Account {

    private volatile int balance;

    public Lock getLock() {
        return lock;
    }

    private Lock lock;

    public Account(int initValue) {
        this.balance = initValue;
        lock = new ReentrantLock();
    }


    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        balance -= amount;
        System.out.println("withdraw balance: " + amount + " by  thread" + Thread.currentThread() + " time: " + System.nanoTime());
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println("deposit balance: " + amount + " by  thread" + Thread.currentThread() + " time: " + System.nanoTime());
    }
}
