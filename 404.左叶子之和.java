/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
 *
 * https://leetcode-cn.com/problems/sum-of-left-leaves/description/
 *
 * algorithms
 * Easy (49.29%)
 * Total Accepted:    5.7K
 * Total Submissions: 11.6K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 计算给定二叉树的所有左叶子之和。
 * 
 * 示例：
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * 
 * 
 * 
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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 0;
        }
        return sumOfLeftLeaves(root.left, true, 0) + sumOfLeftLeaves(root.right, false, 0);
        
    }

    private int sumOfLeftLeaves(TreeNode node, boolean left, int sum) {
        if(node == null) {
            return 0;
        }
        if (node.left == null && node.right == null && left) {
            return sum + node.val;
        }
        if(node.left == null && node.right ==null && !left) {
            return sum;
        }
        return sumOfLeftLeaves(node.left, true, sum) + sumOfLeftLeaves(node.right, false, sum);
        
    }
}

