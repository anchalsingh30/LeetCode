package BinaryTree.src;

import com.sun.source.tree.Tree;
import org.w3c.dom.Node;

public class SubtreeofAnotherTreeBT {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }
        if(root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }
        if(!isIdentical(root.left, subRoot.left)) {
            return false;
        }
        if(!isIdentical(root.right, subRoot.right)) {
            return false;
        }
        return true;

    }
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) {
            return false;
        }
        if(root.val == subRoot.val) {
            if(isIdentical(root, subRoot)){
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
// tc O(n)
// sv O(n)