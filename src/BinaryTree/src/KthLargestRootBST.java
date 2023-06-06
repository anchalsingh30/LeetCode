package BinaryTree.src;

import com.sun.source.tree.Tree;

public class KthLargestRootBST {
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
    public static TreeNode KthLargestElementBST(TreeNode root, int k) {
        if(root == null) {
            return null;
        }
        int count = 0;
        TreeNode right = KthLargestElementBST(root.right, k ); // 40

        if(right != null) {
            return right;
        }
        count++;
        if(count == k) {
            return root;
        }
        return KthLargestElementBST(right.left, k);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(4);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(40);
//        root.right.right.right = new TreeNode(50);

        int K = 3;
        KthLargestElementBST(root, K);


    }
}
