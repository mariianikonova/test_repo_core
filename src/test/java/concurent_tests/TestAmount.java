package concurent_tests;

import concurrent.concurrentImpl.Account;
import concurrent.concurrentImpl.Transfer;
import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by lexor on 11.01.2015.
 */

public class TestAmount {
    @Test
    public void testAdd() {
        Account acc1 = new Account(1000);
        Account acc2 = new Account(2000);
        Transfer transfer = new Transfer();

        transfer.transfer(acc1, acc2, 100);

        TestCase.assertEquals(acc1.getBalance(), 900);
        System.out.println("Assert passed");
    }
}
