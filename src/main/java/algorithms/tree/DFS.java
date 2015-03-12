package algorithms.tree;

import java.util.Stack;
import java.util.Vector;

/**
 * Created by user on 06.03.15.
 */
public class DFS {

    public static void main(String[] args) {

    }

    Boolean[][] graph;
    Boolean[] used;
    int topAmount; //total amount of peaks
    Node root;

    void dfsIterative(Node node) {
        root = node;
        while (node.getIndex() < topAmount - 1) {
            System.out.println("Passed: " + node.getIndex());

            while (node.getLeftNode() != null && used[node.getLeftNode().getIndex()] == false) {
                used[node.getLeftNode().getIndex()] = true;
                System.out.println("Left Passed: " + node.getIndex());
                node = node.getLeftNode();
            }
            node = root;
            while (node.getRightNode() != null && used[node.getRightNode().getIndex()] == false) {
                used[node.getRightNode().getIndex()] = true;
                System.out.println("Right Passed: " + node.getIndex());
                node = node.getRightNode();
            }
        }
    }


    void dfsIterativeStack(Node node) {
        root = node;
        while (node.getIndex() < topAmount - 1) {
            System.out.println("Passed: " + node.getIndex());

            while (node.getLeftNode() != null && used[node.getLeftNode().getIndex()] == false) {
                used[node.getLeftNode().getIndex()] = true;
                System.out.println("Left Passed: " + node.getIndex());
                node = node.getLeftNode();
            }
            node = root;
            while (node.getRightNode() != null && used[node.getRightNode().getIndex()] == false) {
                used[node.getRightNode().getIndex()] = true;
                System.out.println("Right Passed: " + node.getIndex());
                node = node.getRightNode();
            }
        }
    }

    void dfsRecursive(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.println(node.getIndex());
            dfsRecursive(node.getLeftNode());
            dfsRecursive(node.getRightNode());
        }
    }


}
