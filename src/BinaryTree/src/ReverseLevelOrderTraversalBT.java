package BinaryTree.src;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversalBT {
    public class Node {
        int val;
        Node left;
        Node right;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public void reverseLevelOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        Stack<Node> s = new Stack<Node>();

        while(!q.isEmpty()) {
            root = q.poll(); // add/offer the top element in the queue
            if(root.right != null) {
                q.add(root.right);
            }
            if(root.left != null) {
                q.add(root.left);
            }
            s.push(root);
        }
        while (!s.isEmpty()) {
            System.out.println(s.pop().val);
        }

    }

}
