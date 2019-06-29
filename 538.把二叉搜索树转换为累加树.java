/*
 * @lc app=leetcode.cn id=538 lang=java
 *
 * [538] 把二叉搜索树转换为累加树
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    // class TreeNode {
    //     int val;
    //     TreeNode left;
    //     TreeNode right;
    //     TreeNode(int x) { val = x; }
    // }

    public TreeNode convertBST(TreeNode root) {
        if(root == null) {
            return root;
        }
        dfs(root, 0);
        return root;
    }

    public int dfs(TreeNode root, int sum){
        if(root.right != null){
            sum = dfs(root.right, sum);
        }
        root.val += sum;
        if(root.left != null){
            return dfs(root.left, root.val);
        }else return root.val;
    }
}

