package BinaryTree.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DuplicateSubtreeBT {
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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        helper(ans, root, map);
        return ans;
    }

    public String helper(List<TreeNode> ans, TreeNode root, HashMap<String, Integer> map){
        if(root==null) {
            return "";
        }

        String left = helper(ans, root.left, map);
        String right = helper(ans, root.right, map);

        int currentRoot = root.val;
        String stringFormed = currentRoot+"#"+left+"#"+right;
        if(map.getOrDefault(stringFormed, 0)==1){
            ans.add(root);
        }
        map.put(stringFormed, map.getOrDefault(stringFormed, 0) + 1);
        return stringFormed;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.right = new TreeNode(4);

//        System.out.println(findDuplicateSubtrees(root));
    }
}
