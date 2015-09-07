package books.examples.effectiveJava.article_8_commonMethods.equals.transitivity;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @autor mnikonova
 * @since 25.07.15.
 */

/**
 * Problem of mixed comparisons
 */
public class EqualsDemoTrasitiveNegativeExample4 extends ParentPoint {

    /*preparation start*/
    private static final Set<ParentPoint> unitCircle;

    static {
        unitCircle = new HashSet<ParentPoint>();
        unitCircle.add(new ParentPoint(0, 1));
        unitCircle.add(new ParentPoint(0, -1));
        unitCircle.add(new ParentPoint(1, 0));
        unitCircle.add(new ParentPoint(-1, 0));
    }

    public static boolean onUnitCircle(ParentPoint p) {
        return unitCircle.contains(p);
    }
   /*preparation end*/


    private static final AtomicInteger counter = new AtomicInteger();

    public EqualsDemoTrasitiveNegativeExample4(int x, int y, AtomicInteger counter) {
        super(x, y);
        counter.incrementAndGet();
    }

    public int numberCreated() {
        return counter.get();
    }

    /**
     * violation of Barbara Liskov`s substitution principle
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false; //violation of Barbara Liskov`s substitution principle
        if (!super.equals(o)) return false;

        EqualsDemoTrasitiveNegativeExample4 that = (EqualsDemoTrasitiveNegativeExample4) o;
        return !(counter != null ? !counter.equals(that.counter) : that.counter != null);
    }

    public static void main(String[] args) {

        EqualsDemoTrasitiveNegativeExample4 s1 = new EqualsDemoTrasitiveNegativeExample4(1, -1, counter);
        System.out.println("circle contains (s1)" + unitCircle.contains(s1));
        //will return false, cause used getClass();
    }
}
