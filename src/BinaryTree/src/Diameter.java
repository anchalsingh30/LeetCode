package BinaryTree.src;

public class Diameter {
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
    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int myHeight = Math.max(leftHeight, rightHeight) + 1;

        return myHeight;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int diam_left = diameterOfBinaryTree(root.left);
        int diam_right = diameterOfBinaryTree(root.right);

        int diam_root = height(root.left) + height(root.right) + 1;
        int length = Math.max(Math.max(height(root.left), height(root.right)), diam_root);

        return length;
    }
}
