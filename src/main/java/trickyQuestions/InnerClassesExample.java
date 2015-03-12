package trickyQuestions;

/**
 * Created by user on 09.03.15.
 */
//todo
public class InnerClassesExample {

    /*private*/ static int staticVar = 0;
    /*private*/ int instanseVar = 0;

    static class Test {
        private static int count = 0;
        private final static int test1 = staticVar;
        private static int test2;
        //   private static int test2 = instanseVar; //compiler error
        private int test3;


        public synchronized void incrementCount() {

            InnerClassesExample example = new InnerClassesExample();
            test2 = example.instanseVar;
            test3 = example.instanseVar;
            count++;
        }

        //can contain instant inner class
        public class Test2 {
            // private static int count = 0; //!!! cannot have static fields
            private int count = 0;

            private final int test1 = staticVar;
            private int test3;

            public void incrementCount() {
                synchronized (Test.class) {
                    InnerClassesExample example = new InnerClassesExample();
                    test3 = example.instanseVar;
                    count++;
                }
            }
        }
    }

    public class Test2 {
        // private static int count = 0; //!!! cannot have static fields
        private int count = 0;

        private final int test1 = staticVar;
        private int test3;

        public void incrementCount() {
            synchronized (Test.class) {
                InnerClassesExample example = new InnerClassesExample();
                test3 = example.instanseVar;
                count++;
            }
        }

        //instant inner class cannon contain static inner class
        /*static*/ class Test {

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

    public static void main(String[] args) {

        Test3 test3 = new Test3();
        System.out.println("count" + Test3.count);
        System.out.println("count" + test3.count);
    }


}
