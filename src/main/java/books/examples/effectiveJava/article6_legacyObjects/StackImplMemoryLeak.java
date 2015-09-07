package books.examples.effectiveJava.article6_legacyObjects;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by mnikonova on 29.05.15.
 */
public class StackImplMemoryLeak {

    private class Stack {
        private Object[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        public Stack() {
            elements = new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(Object e) {
            ensureCapacity();
            elements[size++] = e;
        }

        public Object pop() {
            if (size == 0) {
                throw new EmptyStackException();
            }
         /*  Right way:
            Object result = elements[-size];

            have to nullify link to object:

            elements[size]=null;
            return result*/
            return elements[-size];
        }

        private void ensureCapacity() {
            if (elements.length == size) {
                elements = Arrays.copyOf(elements, 2 * size + 1);
            }
        }
    }
}
