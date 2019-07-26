/*
 * @lc app=leetcode.cn id=563 lang=java
 *
 * [563] 二叉树的坡度
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

    int sum = 0;

    public int findTilt(TreeNode root) {
        if(root == null) {
            return 0;
        }
        sum += Tilt(root);
        findTilt(root.left);
        findTilt(root.right);
        return sum;
    }

    public int Tilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.abs(sum(root.left) - sum(root.right));
    }

    public int sum(TreeNode node) {
        if(node == null) {
            return 0;
        }
        return sum(node.right) + sum(node.left) + node.val;
    }

    /**
     * 非递归方法 copy from top voted solution
     */
    // public int findTilt(TreeNode root) {
    //     if (root == null) return 0;
    //     int tilt = 0;
    //     Stack<Integer> sums = new Stack<>();
    //     Stack<TreeNode> toVisit = new Stack<>();
    //     TreeNode calc = new TreeNode(0);
    //     toVisit.push(root);
    //     while(!toVisit.isEmpty()) {
    //         TreeNode node = toVisit.pop();
    //         if (node == calc) {
    //             int left = sums.pop(), right = sums.pop();
    //             tilt += Math.abs(left - right);
    //             sums.push(left + right + sums.pop());
    //             continue;
    //         }
    //         sums.push(node.val);
    //         toVisit.push(calc);
    //         if (node.left == null) {
    //             sums.push(0);
    //         } else {
    //             toVisit.push(node.left);
    //         }
    //         if (node.right == null) {
    //             sums.push(0);
    //         } else {
    //             toVisit.push(node.right);
    //         }
    //     }
    //     return tilt;
    // }
}

