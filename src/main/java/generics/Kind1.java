package generics;

/**
 * Created by user on 03.03.15.
 */
public class Kind1 extends Product<Kind1> {


    public Kind1(String name, Integer age) {
        super(name, age);
    }

    public Kind1() {
    }

    @Override
    public int compareTo(Kind1 product) {
        return 0;
    }
}
