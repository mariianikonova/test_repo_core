package concurrent_test;

/**
 * Created by lexor on 11.01.2015.
 */
public class Transfer /*implements Callable<Boolean>*/ {

    public void transfer(Account acc1, Account acc2, int amount) {
        System.out.println("Thread name: " + Thread.currentThread().getName() + " amount: " + amount);
        System.out.println("Thread name: " + Thread.currentThread().getName() + " acc1.balance() before withdraw: " + acc1.getBalance());
        System.out.println("Thread name: " + Thread.currentThread().getName() + " acc2.balance() before withdraw: " + acc2.getBalance());
        if (acc1.getBalance() < amount) {
            Account.incFailedTransferCount();
            try {
                throw new InsufficientFundsException();
            } catch (InsufficientFundsException e) {
                e.printStackTrace();
            }
        }
        if (acc1.getLock().tryLock()) {
            try {
                if (acc2.getLock().tryLock()) {
/*        synchronized (acc1) {*/
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
/*            synchronized (acc1) {*/
                    acc1.withdraw(amount);
                    acc2.deposit(amount);
                    System.out.println("Thread name: " + Thread.currentThread().getName() + " acc1.balance() after withdraw: " + acc1.getBalance());
                    System.out.println("Thread name: " + Thread.currentThread().getName() + " acc2.balance() after withdraw: " + acc2.getBalance());
/*            }
        }*/
                }
            }finally {
                acc1.getLock().unlock();
            }
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class InsufficientFundsException extends Throwable {
    }
}
