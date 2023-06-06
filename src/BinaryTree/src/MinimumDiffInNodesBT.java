package BinaryTree.src;

import org.w3c.dom.Node;

import java.util.ArrayList;

public class MinimumDiffInNodesBT {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
        static TreeNode prev = null;
        static int ans = Integer.MAX_VALUE;

        public static int minDiffInBST(TreeNode root) {
            inorderTraversal(root); // here we can take any helper function name but it follows the inorder traversal in bst
            return ans;
        }

        public static void inorderTraversal(TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraversal(root.left);
            if (prev != null) {
                ans = Math.min(ans, root.val - prev.val); // root.val = 2, 3, 4, 6  // ans = 1, 1, 1, 2
            }
            prev = root; // 1, 2, 3, 4, 6
            inorderTraversal(root.right); //null,
        }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println("Minimum difference between two nodes : " + minDiffInBST(root));

    }
}
