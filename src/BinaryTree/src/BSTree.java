package BinaryTree.src;

import java.util.ArrayList;

public class BSTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) { // O(H)=logn
        if(root == null) {
            root = new Node(val);
            return root;
        }
        if(root.data > val) {
            //left subtree
            root.left = insert(root.left, val);
        }
        else {
            root.right = insert(root.right, val);
        }
        return root;
    }
    // inorder - to verify whether tree is built right
    public static void inorder(Node root) { // ls,r,rs
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
    public static boolean search(Node root, int key) { // O(H)
        if(root == null) {
            return false;
        }
        if(root.data > key) {
            return search(root.left, key);
        }
        else if(root.data == key){
            return true;
        }
        else {
            return search(root.right, key);
        }
    }
    public static Node delete(Node root, int val) {
        if(root.data > val) {
            root.left = delete(root.left, val);
        }
        else if(root.data < val) {
            root.right = delete(root.right, val);
        }
        else { // root.data == val
            // case 1 - leaf node
            if(root.left == null && root.right == null) {
                return null;
            }
            // case 2
            if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }
            // case 3
            Node IS = inorderSuccessor(root.right); // 6, 11
            root.data = IS.data; // left node of tree will become root node to balance the tree
            root.right = delete(root.right, IS.data); // left node need to delete after making it root node
        }
        return root;
    }

    public static Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int X, int Y) { // Q: print numbers in given range x=6, y=10
        if(root == null) {
            return;
        }
        if(root.data >= X && root.data <= Y) {
            printInRange(root.left, X, Y);
            System.out.print(root.data+"->");
            printInRange(root.right, X, Y);
        }
        else if(root.data >= Y) {
            printInRange(root.left, X, Y);
        }
        else {
            printInRange(root.right, X, Y);
        }
    }
    // printPath method for printRoot2Leaf method
    public static void printPath(ArrayList<Integer> path) {
        // traverse the arraylist path to print the elements
        for(int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i)+"-->");
        }
        System.out.println();
    }

    // Q: Print nodes from Leaf to Paths
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        }
        path.add(root.data);

        //if leaf node then print path
        if(root.left == null && root.right == null) {
            printPath(path);
        }
        else { // if non-leaf then print left side path and right side path
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }
        //to remove node from list when you back track for another path for eg from root to right path
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
//        int[] value = {5, 1, 3, 4, 2, 7};
        int[] value = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        for(int i = 0; i < value.length; i++) {
            root = insert(root, value[i]);
        }
//        inorder(root);
//        System.out.println();

//        if(search(root, 4)) {
//            System.out.println("Key found");
//        }
//        else {
//            System.out.println("Key not found");
//        }
//        delete(root, 4); // try deleting 4, 5, 10
//        inorder(root);

        printInRange(root, 1,10);
        System.out.println();

//        System.out.println();
//        printRoot2Leaf(root, new ArrayList<>());
    }
}

