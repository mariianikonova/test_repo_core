package books.examples.effectiveJava.article_8_commonMethods.equals.transitivity;

import java.awt.Color;

/**
 * @autor mnikonova
 * @since 25.07.15.
 */

/**
 *  Problem of mixed comparisons
 */
public class EqualsDemoTrasitiveNegativeExample2 extends ParentPoint {

    private final Color color;

    public EqualsDemoTrasitiveNegativeExample2(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    /**
     * violation of Symmetry
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EqualsDemoTrasitiveNegativeExample1))
            return false; //violation of Symmetry
        EqualsDemoTrasitiveNegativeExample2 that = (EqualsDemoTrasitiveNegativeExample2) o;
        return !(color != null ? !color.equals(that.color) : that.color != null);
    }

    public static void main(String[] args) {
        EqualsDemoTrasitiveNegativeExample2 s1 = new EqualsDemoTrasitiveNegativeExample2(1,2, Color.YELLOW);
        ParentPoint s2 = new ParentPoint(1,2);
        System.out.println("s1.equals(s2)" + s1.equals(s2));
        System.out.println("s2.equals(s1)" + s2.equals(s1));
    }
}
