package books.examples.effectiveJava.article_8_commonMethods.equals.transitivity;

/**
 * Created by mnikonova on 9/7/15.
 */
public class ParentPoint {
    private final int x;
    private final int y;

    public ParentPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParentPoint)) return false;
        ParentPoint that = (ParentPoint) o;
        if (x != that.x) return false;
        return y == that.y;
    }
}
