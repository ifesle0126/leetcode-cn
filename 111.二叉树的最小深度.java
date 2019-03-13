/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (37.27%)
 * Total Accepted:    12.1K
 * Total Submissions: 32.5K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，找出其最小深度。
 * 
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回它的最小深度  2.
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
import java.util.*;


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// [0,0,0,0,null,null,0,null,null,null,0]
class Solution {

    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int minDeep = 1;
        List<TreeNode> stack = new ArrayList();
        stack.add(root);
        while (!stack.isEmpty()) {
            List<TreeNode> line = new ArrayList();
            for(TreeNode tn : stack) {
                if(tn.left != null) {
                    line.add(tn.left);
                }
                if(tn.right != null) {
                    line.add(tn.right);
                }
                if(tn.left == null && tn.right == null) {
                    return minDeep;
                }
            }
            stack = line;
            minDeep++;
        }
        return minDeep;
    }

    // public int minDepth(TreeNode root) {
    //     if(root == null)
    //         return 0;
    //     if(root.left == null)
    //         return minDepth(root.right) + 1;
    //     if(root.right == null)
    //         return minDepth(root.left) + 1;
    //     return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    // }
}

