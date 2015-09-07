package books.examples.effectiveJava.article_8_commonMethods.equals.symmetry;

/**
 * @autor mnikonova
 * @since 05.06.15.
 */
public final class EqualsDemoSymmetryPositiveExample {
    private String s;

    public EqualsDemoSymmetryPositiveExample(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        this.s = s;
    }

    /**
     * Fixed error: symmetry violation
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof EqualsDemoSymmetryPositiveExample && ((EqualsDemoSymmetryPositiveExample) o).s.equalsIgnoreCase(s);
    }

    public static void main(String[] args) {
        EqualsDemoSymmetryPositiveExample s1 = new EqualsDemoSymmetryPositiveExample("Test");
        EqualsDemoSymmetryPositiveExample s2 = new EqualsDemoSymmetryPositiveExample("test");
        System.out.println("s1.equals(s2)" + s1.equals(s2));
        System.out.println("s2.equals(s1)" + s2.equals(s1));
    }

}
