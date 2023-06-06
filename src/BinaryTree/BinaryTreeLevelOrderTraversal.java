package BinaryTree;

import BinaryTree.src.MirrorBT;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            // how many tree nodes we have to process on this current iteration of the loop
            int size = q.size(); //1//2
            //every single level we need to make a list of all nodes value
            List<Integer> currentLevel = new ArrayList<>();
            for(int i = 0; i < size; i++) { // this loop will iterate over the no. of nodes at each level
                root = q.remove(); //3//9//20/-1/-1//15//7
                currentLevel.add(root.val); //<3>//<9>//<20>//<15>//<7>

                if(root.left != null) {
                    q.add(root.left);//9,null,15
                }
                if(root.right != null) {
                    q.add(root.right);//20, null,7
                }

            }
            result.add(currentLevel); // after recording nodes at each level it will get added into result list

        }
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

        BinaryTreeLevelOrderTraversal b = new BinaryTreeLevelOrderTraversal();
        System.out.println(Arrays.asList(b.levelOrder(root)));
//        List<List<Integer>> res = b.levelOrder(root);
//        for(List<Integer> list : res) {
//            System.out.println(list);
//        }
    }
}
