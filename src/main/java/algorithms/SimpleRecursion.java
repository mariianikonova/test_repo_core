package algorithms;

/**
 * Created by user on 06.03.15.
 */
public class SimpleRecursion {
    public static void main(String[] args) {
        recursion("A", 10);
    }

    static void recursion(String s, int amount) {

        if (amount == 0) {
            return;
        } else {
            amount--;
            System.out.println(s);
            recursion(s, amount);
        }
    }
}
