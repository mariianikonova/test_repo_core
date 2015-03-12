package concurrent.basicImpl;

import concurrent.concurrentImpl.Transfer;

/**
 * Created by user on 05.03.15.
 */
public class Operations {

    public static void main(String[] args) {
        final Account a = new Account(1000);
        final Account b = new Account(2000);

        Thread.currentThread().setName(" FIRST ");

        try {
            new Thread(() -> {
                try {
                    Thread.currentThread().setName(" SECOND ");
                    transfer(a, b, 500);
                } catch (Transfer.InsufficientFundsException e) {
                    e.printStackTrace();
                }
            }).start();
            transfer(b, a, 300);

        } catch (Transfer.InsufficientFundsException e) {
            e.printStackTrace();
        }
    }

    private static void transfer(Account a, Account b, int amount) throws Transfer.InsufficientFundsException {

        System.out.println("transfer start: " + amount + " by  thread" + Thread.currentThread() + " time: " + System.nanoTime());

        if (a.getBalance() < amount) {
            throw new Transfer.InsufficientFundsException();
        }

        synchronized (a) {
            //Dead Lock simulation;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (b) {
                a.withdraw(amount);
                b.deposit(amount);
            }
        }
        System.out.println("transfer finished: " + amount + " by  thread" + Thread.currentThread() + " time: " + System.nanoTime());
    }
}
