package concurrent.synchronizers;

import java.util.concurrent.Exchanger;

/**
 * Created by user on 12.03.15.
 */
public class ExchangerDemo {

    public static void main(String[] args) {

        Exchanger<String> exchanger = new Exchanger<>();
        /*should start from consumer*/
        new StringConsumer(exchanger);
        new StringConsumer(exchanger);
        new ThirdPartyProducer(exchanger);
        new ThirdPartyProducer(exchanger);
        new StringProducer(exchanger);
        new StringConsumer(exchanger);
        new StringConsumer(exchanger);
    }


    private static class StringConsumer implements Runnable {
        Exchanger<String> exch;
        String str;

        public StringConsumer(Exchanger<String> exch) {
            this.exch = exch;
            str = new String();
            new Thread(this).start();
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    str = exch.exchange(str);
                    System.out.println("consume buffer: " + str);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class StringProducer implements Runnable {

        Exchanger<String> exch;
        String str;

        public StringProducer(Exchanger<String> exch) {
            this.exch = exch;
            str = new String();
            new Thread(this).start();
        }

        @Override
        public void run() {
            char ch = 'A';
            for (int i = 0; i < 3; i++) {
                str += (char) ch++;
            }
            try {
                System.out.println("produce buffer: " + str);
                str = exch.exchange(str);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ThirdPartyProducer implements Runnable {

        Exchanger<String> exch;
        String str;

        public ThirdPartyProducer(Exchanger<String> exch) {
            this.exch = exch;
            str = new String();
            new Thread(this).start();
        }

        @Override
        public void run() {
            char ch = 'H';
            for (int i = 0; i < 3; i++) {
                str += (char) ch++;
            }
            try {
                System.out.println("produce buffer: " + str);
                str = exch.exchange(str);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
