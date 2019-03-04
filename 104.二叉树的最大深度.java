import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 *
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (67.15%)
 * Total Accepted:    31.1K
 * Total Submissions: 46.3K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，找出其最大深度。
 * 
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回它的最大深度 3 。
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
class Solution {


    class TreeNodeDepth {
        TreeNode treeNode;
        int depth;

        TreeNodeDepth(TreeNode treeNode, int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNodeDepth> stack = new LinkedList<>();
        stack.add(new TreeNodeDepth(root, 1));
        int depth = 0;
        while (!stack.isEmpty()) {
            TreeNodeDepth treeNodeDepth = stack.poll();
            if (treeNodeDepth == null) {
                continue;
            }
            int currentDepth = treeNodeDepth.depth;
            int oldDepth = depth;
            depth = Math.max(currentDepth, oldDepth);
            stack.add(new TreeNodeDepth(treeNodeDepth.treeNode.left, currentDepth + 1));
            stack.add(new TreeNodeDepth(treeNodeDepth.treeNode.right, currentDepth + 1));
        }
        return depth;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}

