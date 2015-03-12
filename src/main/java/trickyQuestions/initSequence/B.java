package trickyQuestions.initSequence;

/**
 * Created by user on 10.03.15.
 */

public class B extends A {
    private int instanceFieldB = fooInit("Class B instance field");
    private static int staticFieldB = fooInit("Class B static(class) field");

    {
        print("Initialization block of B is called");
    }

    static {
        print("Static initialization block of B is called");
    }

    public B() {
        print("Class B constructor called");
    }

    private static void print(String str) {
        System.out.println(str);
    }

    public static int fooInit(String who) {
        System.out.println(String.format("%s initialized", who));
        return 0;
    }
}