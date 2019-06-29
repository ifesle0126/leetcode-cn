/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        nodePath(root);
        return max;
    }

    public int nodePath(TreeNode node) {
        int left = node.left == null ? 0 : nodePath(node.left) + 1;
        int right = node.right == null ? 0 : nodePath(node.right) + 1;
        if (max < (left + right)) {
            max = left + right;
        }
        return Math.max(left , right);
    }


}

