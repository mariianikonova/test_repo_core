package trickyQuestions.initSequence;

/**
 * Created by user on 10.03.15.
 */
public class A {
    private int instanceFieldA = fooInit("Class A instance field");
    private static int staticFieldA = fooInit("Class A static(class) field");

    {
        print("Initialization block of A is called");
    }

    static {
        print("Static initialization block of A is called");
    }

    public A() {
        print("Class A constructor called");
    }

    private static void print(String str) {
        System.out.println(str);
    }

    public static int fooInit(String who) {
        System.out.println(String.format("%s initialized", who));
        return 0;
    }
}