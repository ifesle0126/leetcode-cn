/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
 *
 * https://leetcode-cn.com/problems/path-sum-iii/description/
 *
 * algorithms
 * Easy (48.50%)
 * Total Accepted:    4.5K
 * Total Submissions: 9.2K
 * Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
 *
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 
 * 找出路径和等于给定数值的路径总数。
 * 
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * 
 * 示例：
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 * ⁠     10
 * ⁠    /  \
 * ⁠   5   -3
 * ⁠  / \    \
 * ⁠ 3   2   11
 * ⁠/ \   \
 * 3  -2   1
 * 
 * 返回 3。和等于 8 的路径有:
 * 
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
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

/**
 * 首先先序递归遍历每个节点，再以每个节点的左孩子或者右孩子作为起始点递归寻找满足条件的路径
 * 
 */
class Solution {

    int pathNodeCount = 0;

    public int pathSum(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        addPathNode(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return pathNodeCount;
    }

    private void addPathNode(TreeNode node, int sum) {
        if(node == null) {
            return;
        }
        if (node.val == sum) {
            pathNodeCount++;
        }
        addPathNode(node.left, sum - node.val);
        addPathNode(node.right, sum - node.val);
    }
}

