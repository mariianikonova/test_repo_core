package concurrent_test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lexor on 11.01.2015.
 */
public class Account {

    private int balance;
    private static AtomicInteger failCounter = new AtomicInteger(0);

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    private Lock lock;

    public Account() {
        lock = new ReentrantLock();
    }

    public static AtomicInteger getFailCounter() {
        return failCounter;
    }

    public static void setFailCounter(AtomicInteger failCounter) {
        Account.failCounter = failCounter;
    }

    public Account(int balance) {
        this.balance = balance;
    }

    public static void incFailedTransferCount(){
        failCounter.incrementAndGet();
        System.out.println("FailCounter was updated: " + failCounter);
    }

    public void withdraw (int amount){
        balance-=amount;
    }

    public void  deposit (int amount){
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
