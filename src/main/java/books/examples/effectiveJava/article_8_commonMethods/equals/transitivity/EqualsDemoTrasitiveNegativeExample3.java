package books.examples.effectiveJava.article_8_commonMethods.equals.transitivity;

import java.awt.*;

/**
 * @autor mnikonova
 * @since 25.07.15.
 */

/**
 *  Problem of mixed comparisons
 */
public class EqualsDemoTrasitiveNegativeExample3 extends ParentPoint {

    private final Color color;

    public EqualsDemoTrasitiveNegativeExample3(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    /**
     * violation of Transitivity
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EqualsDemoTrasitiveNegativeExample1))
            return false; //violation of Symmetry
        EqualsDemoTrasitiveNegativeExample3 that = (EqualsDemoTrasitiveNegativeExample3) o;
        return !(color != null ? !color.equals(that.color) : that.color != null);
    }

    public static void main(String[] args) {
        EqualsDemoTrasitiveNegativeExample3 s1 = new EqualsDemoTrasitiveNegativeExample3(1,2, Color.YELLOW);
        ParentPoint s2 = new ParentPoint(1,2);
        EqualsDemoTrasitiveNegativeExample3 s3 = new EqualsDemoTrasitiveNegativeExample3(1,2, Color.YELLOW);
        System.out.println("s1.equals(s2)" + s1.equals(s2));
        System.out.println("s2.equals(s1)" + s2.equals(s1));
        System.out.println("s2.equals(s1)" + s3.equals(s1));
    }
}
