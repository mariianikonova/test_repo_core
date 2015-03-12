package algorithms.tree;

/**
 * Created by user on 06.03.15.
 */
public class Node {

    private int index; //should start from 0
    private Node leftNode;
    private Node rightNode;

    public Node(int index, Node leftNode, Node rightNode) {
        this.index = index;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}
