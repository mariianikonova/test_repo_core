package generics;

/**
 * Created by user on 03.03.15.
 */
public class Kind2 extends Product<Kind2> {

    public Kind2(String name, Integer age) {
        super(name, age);
    }

    public Kind2() {
    }

    @Override
    public int compareTo(Kind2 product) {
        return 0;
    }
}

