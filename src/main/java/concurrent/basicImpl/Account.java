package concurrent.basicImpl;

/**
 * Created by user on 05.03.15.
 */

//need synchronization right to this class
public class Account {

    private volatile int balance;

    public int getBalance() {
        return balance;
    }

    public Account(int initValue) {
        this.balance = initValue;
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
