package concurrent.basicImplLock;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 09.03.15.
 */
public class Transfer implements Callable<Boolean> {
    private Account a;
    private Account b;
    private int amount;
    private int id;

    public Transfer(Account a, Account b, int amount, int id) {
        this.a = a;
        this.b = b;
        this.amount = amount;
        this.id = id;
    }

    @Override
    public Boolean call() throws Exception {
        System.out.println("transfer start: " + amount + " by  thread" + Thread.currentThread() + " time: " + System.nanoTime());

        if (a.getBalance() < amount) {
            throw new concurrent.concurrentImpl.Transfer.InsufficientFundsException("InsufficientFundsException");
        }

        try {
            if (a.getLock().tryLock(200, TimeUnit.MILLISECONDS)) {
                if (b.getLock().tryLock(200, TimeUnit.MILLISECONDS)) {
                    a.withdraw(amount);
                    b.deposit(amount);
                    Thread.sleep(new Random().nextInt());
                }

            } else {
                Statistic.incFailedCounter();
                return false;

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            a.getLock().unlock();
            if (b.getLock().tryLock()) {
                b.getLock().unlock();
            }
        }
        System.out.println("transfer finished: " + amount + " by  thread" + Thread.currentThread() + " time: " + System.nanoTime());
        return true;
    }
}
