package algorithms.dataStructSimpleImpl.queque;

/**
 * Created by user on 11.03.15.
 */
public class QueueImpl {

    public QueueImpl(int capacity) {
        this.capacity = capacity;
        this.queue = new Integer[capacity];
        this.peekIndex = capacity - 1;
        this.tailIndex = capacity - 1;
    }

    public int capacity;
    private Integer[] queue;
    private int peekIndex;
    private int tailIndex;

    public void push(Integer value) {
        System.out.println("push:  peekIndex: " + peekIndex + " tailIndex: " + tailIndex);
        if (tailIndex <= 0) {
            throw new RuntimeException("push: " + "queue is full");
        }
        queue[tailIndex] = value;

        System.out.println("  push:  index: " + tailIndex + " value: " + queue[tailIndex]);
        tailIndex--;
    }

    public Integer peek() {
        System.out.println("peek:  peekIndex: " + peekIndex + " tailIndex: " + tailIndex);

        if (peekIndex < tailIndex || queue[peekIndex] == null) {
            throw new RuntimeException("peek: " + "queue is empty");
        }

        System.out.println("  peek: peekIndex: " + peekIndex + " elem: " + queue[peekIndex].toString());
        return queue[peekIndex];
    }


    public Integer pop() {
        System.out.println("pop:  peekIndex: " + peekIndex + " tailIndex: " + tailIndex);
        if (peekIndex < tailIndex || peekIndex < 0) {
            throw new RuntimeException("pop: " + "queue is empty");
        }

        Integer val = queue[peekIndex];
        queue[peekIndex] = null;
        System.out.println("  pop:  peekIndex: " + peekIndex + " elem: " + val.toString());
        peekIndex--;
        return val;
    }

    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl(10);
        queue.push(new Integer(5));
        queue.push(new Integer(2));
        queue.push(new Integer(6));
        queue.peek();
        queue.pop();
        queue.peek();
        queue.pop();
        queue.peek();
        queue.pop();
        queue.peek();
    }
}
