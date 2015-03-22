package algorithms.dataStructSimpleImpl.stack;

/**
 * Created by user on 11.03.15.
 */
public class StackArrayImpl {

    public StackArrayImpl(int capacity) {
        this.capacity = capacity;
        this.stack = new Integer[capacity];
    }

    public int capacity = 0;
    private Integer[] stack;
    private int peekIndex = 0;

    public void push(Integer value) {
        if (peekIndex >= capacity) {
            throw new RuntimeException("peek: " + "stack is full");
        }
        stack[peekIndex] = value;
        System.out.println("push:  index: " + peekIndex + " value: " + stack[peekIndex]);
        peekIndex++;
    }

    public Integer peek() {
        if (stack[peekIndex - 1] == null) {
            throw new RuntimeException("peek: " + "stack is empty");
        }
        System.out.println("peek: " + stack[peekIndex - 1].toString());
        return stack[peekIndex - 1];
    }


    public Integer pop() {
        if (peekIndex - 1 < 0 || peekIndex - 2 < 0) {
            throw new RuntimeException("pop: " + "stack is empty");
        }

        Integer val = stack[peekIndex - 1];
        stack[peekIndex - 1] = null;
        if (stack[peekIndex - 2] != null) {
            peekIndex--;
        }
        System.out.println("pop: " + val.toString());
        return val;
    }

    public static void main(String[] args) {
        StackArrayImpl stack = new StackArrayImpl(100);
        stack.push(new Integer(5));
        stack.push(new Integer(2));
        stack.push(new Integer(6));
        stack.peek();
        stack.peek();
        stack.pop();
        stack.peek();
        stack.pop();
        stack.peek();
        stack.pop();
        stack.peek();
    }
}
