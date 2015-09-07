package books.examples.effectiveJava.article_8_commonMethods.equals.transitivity;

import java.awt.Color;

/**
 * @autor mnikonova
 * @since 25.07.15.
 */

//TODO: haven`t not prepared yet
public class EqualsDemoTrasitivePositiveExample extends ParentPoint {

        private final Color color;

        public EqualsDemoTrasitivePositiveExample(int x, int y, Color color) {
            super(x, y);
            this.color = color;
        }

        /**
         * violation of Barbara Liskov`s substitution principle
         **/
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass())
                return false; //violation of Barbara Liskov`s substitution principle
            if (!super.equals(o)) return false;

            EqualsDemoTrasitivePositiveExample that = (EqualsDemoTrasitivePositiveExample) o;
            return !(color != null ? !color.equals(that.color) : that.color != null);
        }

        public static void main(String[] args) {
            EqualsDemoTrasitiveNegativeExample1 s1 = new EqualsDemoTrasitiveNegativeExample1(1,2, Color.YELLOW);
            EqualsDemoTrasitiveNegativeExample1 s2 = new EqualsDemoTrasitiveNegativeExample1(1,2, Color.YELLOW);
            System.out.println("s1.equals(s2)" + s1.equals(s2));
            System.out.println("s2.equals(s1)" + s2.equals(s1));
        }
}
