package concurrent.basicMultiThreading;

/**
 * Created by user on 09.03.15.
 */
public class StaticSynchExample {

    public static class Test {
        private static int count = 0;

        public static synchronized void incrementCount() {
            count++;
        }
    }

    public static class Test2 {
        private static int count = 0;

        public void incrementCount() {
            synchronized (Test.class) {
                count++;
            }
        }
    }

    public static class Test3 {
        private static int count = 0;
        private static final Object countLock = new Object();

        public void incrementCount() {
            synchronized (countLock) {
                count++;
            }
        }
    }
    // Method 3 is the best in many cases because the lock object is not exposed outside of your class.

}
