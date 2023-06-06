package BinaryTree.src;

public class BinarySearchTree {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }

    }
    public static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.val > val) {
            root.left = insert(root.left, val);
        } else if (root.val < val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static boolean search(Node root, int val) {
        if (root == null) {
            return false;
        }
        if (root.val > val) {
            return search(root.left, val);
        }
        else if(root.val == val) {
            return true;
        }
        else { // 8, 10, 11, 14
            return search(root.right, val);
        }

    }

    public static Node delete(Node root, int val) {
        if(root.val > val) {
            root.left = delete(root.left, val);
        }
        else if(root.val < val) {
            root.right = delete(root.right, val);
        }
        else {
            //case 1: if leaf node
            if(root.left == null && root.right == null) {
                return null;
            } // case 2: if node has two children
            if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }
            Node IS = inorderSuccessor(root.right);
            root.val = IS.val; // root 5 replaced with its right node root 6
            root.right = delete(root.right, IS.val);

        }
        return root;
    }

    public static Node inorderSuccessor(Node root) {
        if(root.left != null) {
            root = root.left;
        }
        return root;
    }


    public static void main(String[] args) {
        int[] value = {8, 5, 3, 1, 4, 6, 2, 10, 11, 14};
        Node root = null;
        for (int i = 0; i < value.length; i++) {
            root = insert(root, value[i]);
        }
        inorder(root); // to check the bst is in order

        if (search(root, 14)) {
            System.out.println("\n Value found");
        }
        else
        {
            System.out.println("\n Value not found");
        }

        delete(root, 2);
        inorder(root);
    }

}
