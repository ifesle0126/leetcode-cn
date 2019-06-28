/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
 *
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/description/
 *
 * algorithms
 * Easy (53.90%)
 * Likes:    61
 * Dislikes: 0
 * Total Accepted:    4.4K
 * Total Submissions: 8.2K
 * Testcase Example:  '[1,null,3,2]'
 *
 * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 * 
 * 示例 :
 * 
 * 
 * 输入:
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    3
 * ⁠   /
 * ⁠  2
 * 
 * 输出:
 * 1
 * 
 * 解释:
 * 最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * 
 * 
 * 注意: 树中至少有2个节点。
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


class Solution {

    // class TreeNode {
    //     int val;
    //     TreeNode left;
    //     TreeNode right;
    //     TreeNode(int x) { val = x; }
    // }


    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        scanner(root, list);
        return min;
    }

    int min = Integer.MAX_VALUE;

    public void scanner(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        scanner(node.left, list);
        list.add(node.val);
        if (list.size() > 1) {
            int tmp = list.get(list.size() - 1) - list.get(list.size() - 2);
            min = tmp < min ? tmp : min;
        }
        scanner(node.right, list);
    }

    // public int getMinimumDifference1(TreeNode root) {
    //     List<Integer> list = new ArrayList<>();
    //     scanner1(root, list);
    //     int min = list.get(1) - list.get(0);
    //     if(list.size() == 2) {
    //         return min;
    //     }
    //     for(int i = 1; i < list.size() - 1; i++) {
    //         int tmp = list.get(i + 1) - list.get(i);
    //         if(tmp < min) {
    //             min = tmp;
    //         }
    //     }
    //     return min;
    // }

    // public void scanner1(TreeNode node, List<Integer> list) {
    //     if (node == null) {
    //         return;
    //     }
    //     scanner1(node.left, list);
    //     list.add(node.val);
    //     scanner1(node.right, list);
    // }
}

