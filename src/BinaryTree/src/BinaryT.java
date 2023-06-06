package BinaryTree.src;

import com.sun.source.tree.Tree;

import static javax.swing.Spring.height;

public class BinaryT {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data =  data;
            this.left = null;
            this.right = null;
        }
    }

     static class BinaryTree {
        static int idx = -1;
        public static Node binaryTree(int[] nodes) {
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = binaryTree(nodes);
            newNode.right = binaryTree(nodes);

            return newNode;
        }
    }
    public static void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public static void postorder(Node root) {
        if(root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    public static int countOfNodes(Node root) {
        if(root == null) {
            return 0;
        }
        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);
        return leftNodes + rightNodes + 1;
    }

    public static int sumOfNodes(Node root) {
        if(root == null) {
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    public static int heightOfTree(Node root) {
         if(root == null) {
             return 0;
         }
         int leftHeight = heightOfTree(root.left);
         int rightHeight = heightOfTree(root.right);
         int myHeight = Math.max(leftHeight, rightHeight) + 1;
        return myHeight;
    }

    //Diameter approach - 1 = O(n^2)
    public static int diameter(Node root) {
        if(root == null) {
            return 0;
        }
        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;

        return Math.max(diam3, Math.max(diam1,diam2));
    }
    //Diameter approach - 2 = O(n)
    static class TreeInfo {
        int ht;
        int diam;
        TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }
    public static TreeInfo diameter2(Node root) { // taking method type as TreeInfo because each node is returning height and diam together
        if(root == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo left = diameter2(root.left); // height of left subtree
        TreeInfo right = diameter2(root.right); // height of right subtree

        int myHeight = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int myDiam = Math.max(Math.max(diam1, diam2), diam3);

        TreeInfo myInfo = new TreeInfo(myHeight, myDiam);
        return myInfo;
    }
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.binaryTree(nodes);
//      System.out.println(root.data);
//      preorder(root);
      inorder(root);
//        postorder(root);
//        System.out.println(countOfNodes(root));
//        System.out.println(sumOfNodes(root));
//        System.out.println(heightOfTree(root)
        System.out.println(diameter2(root).diam);
    }
}