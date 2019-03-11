/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 *
 * https://leetcode-cn.com/problems/balanced-binary-tree/description/
 *
 * algorithms
 * Easy (46.43%)
 * Total Accepted:    11.4K
 * Total Submissions: 24.5K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 
 * 本题中，一棵高度平衡二叉树定义为：
 * 
 * 
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 
 * 
 * 示例 1:
 * 
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回 true 。
 * 
 * 示例 2:
 * 
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   2
 * ⁠   / \
 * ⁠  3   3
 * ⁠ / \
 * ⁠4   4
 * 
 * 
 * 返回 false 。
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
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        } else if (Math.abs(treeDeep(root.left) - treeDeep(root.right)) > 1) {
            return false;
        } else {
            return isBalanced(root.left) & isBalanced(root.right);
        }
    
    }

    public int treeDeep(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = treeDeep(node.left);
        int right = treeDeep(node.right);
        return left > right ? left + 1 : right + 1;
    }
}




// public boolean isBalanced(TreeNode root) {
//     if(root == null) {
//         return true;
//     }
//     int d = treeDeep(root, 1);
//     if (d == -1) {
//         return false;
//     }
//     return true;
// }

// public int treeDeep(TreeNode node, int deep) {
//     if(node == null) {
//         return deep;
//     }
//     int left = treeDeep(node.left, deep + 1);
//     if (left == -1){
//         return -1;
//     }
//     int right = treeDeep(node.right, deep + 1);
//     if(right == -1) {
//         return -1;
//     }
//     if(Math.abs(left - right) > 1) {
//         return -1;
//     }
//     return left > right ? left : right;
// }

