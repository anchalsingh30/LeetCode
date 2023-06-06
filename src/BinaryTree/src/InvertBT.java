package BinaryTree.src;

public class InvertBT {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode invertTree(TreeNode root) {
        //recursive approach
        if(root == null ) {
            return null;
        }
        //invert child trees
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        //swap children
        TreeNode temp = root.left ;
        root.left = root.right;
        root.right = temp;

        return root;
    }
}
//tc O(n)
// sc O(n)