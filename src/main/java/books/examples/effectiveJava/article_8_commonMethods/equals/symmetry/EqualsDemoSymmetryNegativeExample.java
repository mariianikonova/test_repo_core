package books.examples.effectiveJava.article_8_commonMethods.equals.symmetry;

/**
 * @autor mnikonova
 * @since 05.06.15.
 */
public final class EqualsDemoSymmetryNegativeExample {
    private String s;

    public EqualsDemoSymmetryNegativeExample(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        this.s = s;
    }

    /**
     * Error: symmetry violation
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof EqualsDemoSymmetryNegativeExample) {
            return s.equalsIgnoreCase(((EqualsDemoSymmetryNegativeExample) o).s);
        }
        if (o instanceof String) { //OneDirection interaction
            return s.equalsIgnoreCase((String) o);
        }
        return false;
    }

    public static void main(String[] args) {
        EqualsDemoSymmetryNegativeExample s1 = new EqualsDemoSymmetryNegativeExample("Test");
        String s2 = "test";
        System.out.println("s1.equals(s2)" + s1.equals(s2));
        System.out.println("s2.equals(s1)" + s2.equals(s1));
    }

}
