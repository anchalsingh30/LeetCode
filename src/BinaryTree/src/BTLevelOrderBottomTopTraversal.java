package BinaryTree.src;

import BinaryTree.BinaryTreeLevelOrderTraversal;
import com.sun.source.tree.Tree;

import java.util.*;

public class BTLevelOrderBottomTopTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrderBottomUp(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        Stack<List<Integer>> stack = new Stack();

        if (root == null)
            return result;

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                root = q.remove();
                list.add(root.val);

                if (root.left != null) {
                    q.add(root.left);
                }
                if (root.right != null) {
                    q.add(root.right);
                }
            }
            stack.push(list);

        }
        while (!stack.isEmpty())
            result.add(stack.pop());

        return result;

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
        root.left = createNode(9);
        root.right = createNode(20);
//        root.left.left = createNode(-1); // sending -1 as null
//        root.left.right = createNode(-1);
        root.right.left = createNode(15);
        root.right.right = createNode(7);

        BTLevelOrderBottomTopTraversal b = new BTLevelOrderBottomTopTraversal();
        System.out.println(Arrays.asList(b.levelOrderBottomUp(root)));
    }
}
