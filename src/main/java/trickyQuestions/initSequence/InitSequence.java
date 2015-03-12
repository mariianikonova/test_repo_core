package trickyQuestions.initSequence;

/**
 * Created by user on 10.03.15.
 */

public class InitSequence {
    public static void main(String[] args) {
        new B();
    }
}

/*  Class A static(class) field initialized
    Static initialization block of A is called
    Class B static(class) field initialized
    Static initialization block of B is called
    Class A instance field initialized
    Initialization block of A is called
    Class A constructor called
    Class B instance field initialized
    Initialization block of B is called
    Class B constructor called*/



