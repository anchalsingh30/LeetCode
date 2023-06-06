package BinaryTree.src;

public class MirrorBT {
    static class Node
    {
        int val;
        Node left;
        Node right;
    }
    public static Node createNode(int val) {
        Node newNode = new Node();
        newNode.val = val;
        newNode.left = null;
        newNode.right = null;

        return newNode;
    }
    public static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
    public static Node mirrorTree(Node root) {
        if(root == null) {
            return null;
        }
        Node left = mirrorTree(root.left);
        Node right = mirrorTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }


    public static void main(String[] args) {
        Node root = createNode(5);
        root.left = createNode(3);
        root.right = createNode(6);
        root.left.left = createNode(2);
        root.left.right = createNode(4);
        System.out.println("Inorder of original tree: ");
        inorder(root);

        mirrorTree(root);

        System.out.println("\n Inorder of mirror tree: ");
        inorder(root);
    }
}
