package BinaryTree.src;

import com.sun.source.tree.Tree;

import java.util.Arrays;

public class MinimumDepthBT {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        if(root.left == null && root.right == null) {
            return 1;
        }
        if(root.left == null) {
            return 1 + rightDepth;
        }
        if(root.right == null) {
            return 1 + leftDepth;
        }
        return Math.min(leftDepth, rightDepth) + 1;
     }
    public static TreeNode createNode(int val) {
        TreeNode newNode = new TreeNode();
        newNode.val = val;
        newNode.left = null;
        newNode.right = null;

        return newNode;
    }
    public static void main(String[] args) {
        TreeNode root = createNode(3);
//        root.left = createNode(9);
        root.right = createNode(20);
        root.right.left = createNode(15);
        root.right.right = createNode(7);

        MinimumDepthBT m = new MinimumDepthBT();
        System.out.println(m.minDepth(root));
    }
}
