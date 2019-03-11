import java.util.*;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (58.92%)
 * Total Accepted:    10.2K
 * Total Submissions: 17.2K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其自底向上的层次遍历为：
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
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

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> resultSet = new LinkedList<>();
        List<TreeNode> stack = new ArrayList<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            List<Integer> tmp = new ArrayList<>();
            for(TreeNode tn : stack) {
                tmp.add(tn.val);
                if (tn.left != null) {
                    list.add(tn.left);
                }
                if (tn.right != null) {
                    list.add(tn.right);
                }
            }
            stack = list;
            resultSet.add(0, tmp);
        }
        return resultSet;
    }
}

